package rocks.milspecsg.msitemban.api.banrule.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.MongoRepository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface MongoBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends MongoRepository<TBanRule, BanRuleCacheService<ObjectId, TBanRule>>,
    BanRuleRepository<ObjectId, TBanRule, Datastore> {

    CompletableFuture<Optional<TBanRule>> create(String name);

}
