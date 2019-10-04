package rocks.milspecsg.msitemban.service.banrule.repository;

import org.bson.types.ObjectId;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.MongoRepository;
import rocks.milspecsg.msrepository.datastore.mongodb.MongoContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiMongoRepository;

public abstract class ApiMongoBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends ApiMongoRepository<TBanRule>
    implements MongoRepository<TBanRule>,
    BanRuleRepository<ObjectId, TBanRule> {

    public ApiMongoBanRuleRepository(MongoContext mongoContext) {
        super(mongoContext);
    }



}
