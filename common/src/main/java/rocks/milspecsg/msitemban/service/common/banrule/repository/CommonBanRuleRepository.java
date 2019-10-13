package rocks.milspecsg.msitemban.service.common.banrule.repository;

import rocks.milspecsg.msitemban.api.banrule.cache.BanRuleCacheService;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.DataStoreConfig;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.service.apirepository.ApiRepository;

public abstract class CommonBanRuleRepository<
    TKey,
    TBanRule extends BanRule<TKey>,
    TDataStore,
    TDataStoreConfig extends DataStoreConfig>
    extends ApiRepository<TKey, TBanRule, BanRuleCacheService<TKey, TBanRule>, TDataStore, TDataStoreConfig>
    implements BanRuleRepository<TKey, TBanRule, TDataStore, TDataStoreConfig> {

    public CommonBanRuleRepository(DataStoreContext<TKey, TDataStore, TDataStoreConfig> dataStoreContext) {
        super(dataStoreContext);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<TBanRule> getTClass() {
        return (Class<TBanRule>) getDataStoreContext().getEntityClassUnsafe("banrule");
    }
}
