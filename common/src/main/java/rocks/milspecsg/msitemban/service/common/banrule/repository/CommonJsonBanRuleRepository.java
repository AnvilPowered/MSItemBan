package rocks.milspecsg.msitemban.service.common.banrule.repository;

import com.google.inject.Inject;
import io.jsondb.JsonDBOperations;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;
import rocks.milspecsg.msrepository.service.apirepository.ApiJsonRepository;

import java.util.concurrent.CompletableFuture;

public class CommonJsonBanRuleRepository<TBanRule extends BanRule<String>>
    extends CommonBanRuleRepository<String, TBanRule, JsonDBOperations, JsonConfig>
    implements ApiJsonRepository<TBanRule, BanRuleCacheService<String, TBanRule>>,
    BanRuleRepository<String, TBanRule, JsonDBOperations, JsonConfig> {

    @Inject
    public CommonJsonBanRuleRepository(DataStoreContext<String, JsonDBOperations, JsonConfig> dataStoreContext) {
        super(dataStoreContext);
    }

    @Override
    public CompletableFuture<Boolean> delete(String name) {
        return null;
    }
}
