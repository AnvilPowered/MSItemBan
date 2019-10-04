package rocks.milspecsg.msitemban.service.banrule.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.MongoRepository;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiMongoRepository;

import java.util.concurrent.CompletableFuture;

public abstract class ApiMongoBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends ApiMongoRepository<TBanRule>
    implements MongoRepository<TBanRule>,
    BanRuleRepository<ObjectId, TBanRule> {

    public ApiMongoBanRuleRepository(DataStoreContext<Datastore> mongoContext) {
        super(mongoContext);
    }

    @Override
    public CompletableFuture<Boolean> delete(String name) {
        return CompletableFuture.supplyAsync(() -> dataStoreContext.getDataStore().map(ds -> ds.delete(asQuery().field("name").equal(name)).getN() > 0).orElse(false));
    }
}
