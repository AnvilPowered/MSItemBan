package rocks.milspecsg.msitemban.service.sponge.banrule.repository;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonMongoBanRuleRepository;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class MSSpongeMongoBanRuleRepository extends CommonMongoBanRuleRepository<MongoBanRule> {

    @Inject
    public MSSpongeMongoBanRuleRepository(DataStoreContext<Datastore> mongoContext) {
        super(mongoContext);
    }

    @Override
    public MongoBanRule generateEmpty() {
        return new MongoBanRule();
    }

    @Override
    public TypeToken<MongoBanRule> getTypeTokenT() {
        return null;
    }

    @Override
    public Optional<UpdateOperations<MongoBanRule>> createUpdateOperations() {
        return getDataStoreContext().getDataStore().map(d -> d.createUpdateOperations(MongoBanRule.class));
    }

    @Override
    public Optional<Query<MongoBanRule>> asQuery() {
        return getDataStoreContext().getDataStore().map(d -> d.createQuery(MongoBanRule.class));
    }

    private static TypeToken<ObjectId> typeTokenTKey = new TypeToken<ObjectId>() {};

    @Override
    public TypeToken<ObjectId> getTypeTokenTKey() {
        return typeTokenTKey;
    }

    @Override
    public ObjectId assertType(Object id) throws ClassCastException {
        return (ObjectId) id;
    }
}
