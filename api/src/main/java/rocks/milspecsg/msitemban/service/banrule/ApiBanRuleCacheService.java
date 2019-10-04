package rocks.milspecsg.msitemban.service.banrule;

import rocks.milspecsg.msitemban.api.banrule.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.service.cache.ApiRepositoryCacheService;

public abstract class ApiBanRuleCacheService<TKey, TBanRule extends BanRule<TKey>>
    extends ApiRepositoryCacheService<TKey, TBanRule>
    implements RepositoryCacheService<TKey, TBanRule>,
    BanRuleCacheService<TKey, TBanRule> {

    public ApiBanRuleCacheService(ConfigurationService configurationService) {
        super(configurationService);
    }
}
