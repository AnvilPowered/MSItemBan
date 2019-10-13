package rocks.milspecsg.msitemban.service.common.banrule;

import com.google.inject.Inject;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.api.manager.Manager;
import rocks.milspecsg.msrepository.api.tools.resultbuilder.StringResult;
import rocks.milspecsg.msrepository.service.apimanager.ApiManager;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CommonBanRuleManager<TBanRule extends BanRule<?>, TItemStack, TString>
    extends ApiManager<TBanRule, BanRuleRepository<?, TBanRule, ?, ?>>
    implements Manager<TBanRule, BanRuleRepository<?, TBanRule, ?, ?>>,
    BanRuleManager<TBanRule, TItemStack, TString> {

    @Inject
    StringResult<TString> stringResult;

    @Inject
    public CommonBanRuleManager(ConfigurationService configurationService) {
        super(configurationService);
    }

    @Override
    public CompletableFuture<TString> create(String name) {
        return CompletableFuture.supplyAsync(() -> {

            TBanRule toInsert = getPrimaryStorageService().generateEmpty();
            toInsert.setName(name);

            Optional<TBanRule> optionalBanRule = getPrimaryStorageService().insertOne(toInsert).join();

            if (optionalBanRule.isPresent()) {
                return stringResult.builder()
                    .gray().append("Succesfully created banrule ")
                    .gold().append(optionalBanRule.get().getName())
                    .gray().append(" with id ")
                    .gold().append(optionalBanRule.get().getId())
                    .build();
            } else {
                return stringResult.fail("Error creating banrule " + name);
            }
        });
    }

    @Override
    public CompletableFuture<TString> delete(String name) {
        return getPrimaryStorageService().delete(name).thenApply(result -> {
            if (result) {
                return stringResult.builder()
                    .gray().append("Succesfully deleted banrule ")
                    .gold().append(name)
                    .build();
            } else {
                return stringResult.fail("Error deleting banrule " + name);
            }
        });
    }

    @Override
    public boolean check(TItemStack itemStack) {
        return false;
    }
}
