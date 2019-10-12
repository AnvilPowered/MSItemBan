package rocks.milspecsg.msitemban.service.common.banrule.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiMongoRepository;

import java.util.concurrent.CompletableFuture;

public abstract class CommonMongoBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends CommonBanRuleRepository<ObjectId, TBanRule, Datastore>
    implements ApiMongoRepository<TBanRule, BanRuleCacheService<ObjectId, TBanRule>>,
    BanRuleRepository<ObjectId, TBanRule, Datastore> {

    public CommonMongoBanRuleRepository(DataStoreContext<Datastore> mongoContext) {
        super(mongoContext);
    }

    @Override
    public CompletableFuture<Boolean> delete(String name) {
        return CompletableFuture.supplyAsync(() ->
            getDataStoreContext().getDataStore()
                .flatMap(ds ->
                    asQuery().map(q -> ds.delete(q.field("name").equal(name)).getN() > 0)
                ).orElse(false));
    }
}
