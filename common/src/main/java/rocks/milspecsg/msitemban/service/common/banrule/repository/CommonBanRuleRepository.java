package rocks.milspecsg.msitemban.service.common.banrule.repository;

import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiRepository;

public abstract class CommonBanRuleRepository<TKey, TBanRule extends BanRule<TKey>, TDataStore> extends ApiRepository<TKey, TBanRule, BanRuleCacheService<TKey, TBanRule>, TDataStore> {

    public CommonBanRuleRepository(DataStoreContext<TDataStore> dataStoreContext) {
        super(dataStoreContext);
    }
}
