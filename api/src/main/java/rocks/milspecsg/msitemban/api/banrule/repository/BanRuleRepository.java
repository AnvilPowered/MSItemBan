package rocks.milspecsg.msitemban.api.banrule.repository;

import rocks.milspecsg.msitemban.api.banrule.BanRuleStorageService;
import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.Repository;

public interface BanRuleRepository<TKey, TBanRule extends BanRule<TKey>, TDataStore>
    extends Repository<TKey, TBanRule, BanRuleCacheService<TKey, TBanRule>, TDataStore>,
    BanRuleStorageService<TKey, TBanRule> {

}
