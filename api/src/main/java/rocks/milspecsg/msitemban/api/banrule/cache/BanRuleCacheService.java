package rocks.milspecsg.msitemban.api.banrule.cache;

import rocks.milspecsg.msitemban.api.banrule.BanRuleStorageService;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;

public interface BanRuleCacheService<TKey, TBanRule extends BanRule<TKey>>
    extends RepositoryCacheService<TKey, TBanRule>,
    BanRuleStorageService<TKey, TBanRule> {
}
