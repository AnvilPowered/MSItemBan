package rocks.milspecsg.msitemban.service.banrule;

import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.api.manager.Manager;
import rocks.milspecsg.msrepository.service.apimanager.ApiManager;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class ApiBanRuleManager<TKey, TBanRule extends BanRule<TKey>, TItemStack>
    extends ApiManager<TKey, TBanRule, BanRuleRepository<TKey, TBanRule>>
    implements Manager<TKey, TBanRule, BanRuleRepository<TKey, TBanRule>>,
    BanRuleManager<TKey, TBanRule, TItemStack> {

    public ApiBanRuleManager(ConfigurationService configurationService) {
        super(configurationService);
    }

    @Override
    public CompletableFuture<Optional<TBanRule>> create(TBanRule banRule) {
        return getPrimaryRepository().insertOne(banRule);
    }

    @Override
    public CompletableFuture<Boolean> delete(String name) {
        return getPrimaryRepository().deleteOne(name);
    }
}
