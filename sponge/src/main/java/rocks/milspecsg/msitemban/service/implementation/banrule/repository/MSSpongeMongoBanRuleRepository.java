package rocks.milspecsg.msitemban.service.implementation.banrule.repository;

import com.google.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;
import rocks.milspecsg.msitemban.service.banrule.repository.ApiMongoBanRuleRepository;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

public class MSSpongeMongoBanRuleRepository extends ApiMongoBanRuleRepository<MongoBanRule> {

    @Inject
    public MSSpongeMongoBanRuleRepository(DataStoreContext<Datastore> mongoContext) {
        super(mongoContext);
    }

    @Override
    public MongoBanRule generateEmpty() {
        return new MongoBanRule();
    }

    @Override
    public UpdateOperations<MongoBanRule> createUpdateOperations() {
        return dataStoreContext.getDataStore().orElseThrow(IllegalAccessError::new).createUpdateOperations(MongoBanRule.class);
    }

    @Override
    public Query<MongoBanRule> asQuery() {
        return dataStoreContext.getDataStore().orElseThrow(IllegalAccessError::new).createQuery(MongoBanRule.class);
    }
}
