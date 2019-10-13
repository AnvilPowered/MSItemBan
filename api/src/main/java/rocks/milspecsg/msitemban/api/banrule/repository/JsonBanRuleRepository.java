package rocks.milspecsg.msitemban.api.banrule.repository;

import io.jsondb.JsonDBOperations;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.JsonRepository;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;

public interface JsonBanRuleRepository<TBanRule extends BanRule<String>>
    extends JsonRepository<TBanRule, BanRuleCacheService<String, TBanRule>>,
    BanRuleRepository<String, TBanRule, JsonDBOperations, JsonConfig> {
}
