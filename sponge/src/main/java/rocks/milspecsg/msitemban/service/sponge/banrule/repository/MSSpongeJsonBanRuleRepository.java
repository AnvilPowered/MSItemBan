package rocks.milspecsg.msitemban.service.sponge.banrule.repository;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import rocks.milspecsg.msitemban.model.data.core.banrule.JsonBanRule;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonJsonBanRuleRepository;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

public class MSSpongeJsonBanRuleRepository extends CommonJsonBanRuleRepository<JsonBanRule> {

    @Inject
    public MSSpongeJsonBanRuleRepository(DataStoreContext<JsonDBOperations> dataStoreContext) {
        super(dataStoreContext);
    }

    @Override
    public String assertType(Object id) throws ClassCastException {
        return id.toString();
    }

    @Override
    public JsonBanRule generateEmpty() {
        return new JsonBanRule();
    }

    private static TypeToken<String> typeTokenTKey = new TypeToken<String>() {};

    @Override
    public TypeToken<String> getTypeTokenTKey() {
        return typeTokenTKey;
    }

    private static TypeToken<JsonBanRule> typeTokenT = new TypeToken<JsonBanRule>() {};

    @Override
    public TypeToken<JsonBanRule> getTypeTokenT() {
        return typeTokenT;
    }
}
