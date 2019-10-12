package rocks.milspecsg.msitemban.service.common.banrule.repository;

import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiJsonRepository;

import java.util.concurrent.CompletableFuture;

public abstract class CommonJsonBanRuleRepository<TBanRule extends BanRule<String>>
    extends CommonBanRuleRepository<String, TBanRule, JsonDBOperations>
    implements ApiJsonRepository<TBanRule, BanRuleCacheService<String, TBanRule>>,
    BanRuleRepository<String, TBanRule, JsonDBOperations> {

    public CommonJsonBanRuleRepository(DataStoreContext<JsonDBOperations> dataStoreContext) {
        super(dataStoreContext);
    }

    @Override
    public CompletableFuture<Boolean> delete(String name) {
        return null;
    }
}
