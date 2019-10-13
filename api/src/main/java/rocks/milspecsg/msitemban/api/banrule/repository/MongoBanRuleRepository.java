package rocks.milspecsg.msitemban.api.banrule.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.MongoRepository;
import rocks.milspecsg.msrepository.datastore.mongodb.MongoConfig;

public interface MongoBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends MongoRepository<TBanRule, BanRuleCacheService<ObjectId, TBanRule>>,
    BanRuleRepository<ObjectId, TBanRule, Datastore, MongoConfig> {

}
