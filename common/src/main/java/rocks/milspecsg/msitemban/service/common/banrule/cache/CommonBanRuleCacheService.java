package rocks.milspecsg.msitemban.service.common.banrule.cache;

import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.service.cache.ApiRepositoryCacheService;

public abstract class CommonBanRuleCacheService<TKey, TBanRule extends BanRule<TKey>>
    extends ApiRepositoryCacheService<TKey, TBanRule>
    implements RepositoryCacheService<TKey, TBanRule>,
    BanRuleCacheService<TKey, TBanRule> {

    public CommonBanRuleCacheService(ConfigurationService configurationService) {
        super(configurationService);
    }
}
