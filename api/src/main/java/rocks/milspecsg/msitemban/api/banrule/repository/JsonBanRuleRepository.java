package rocks.milspecsg.msitemban.api.banrule.repository;

import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.JsonRepository;

public interface JsonBanRuleRepository<TBanRule extends BanRule<ObjectId>>
    extends JsonRepository<TBanRule, BanRuleCacheService<ObjectId, TBanRule>>,
    BanRuleRepository<ObjectId, TBanRule, JsonDBOperations> {
}
