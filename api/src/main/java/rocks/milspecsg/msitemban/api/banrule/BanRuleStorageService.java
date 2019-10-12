package rocks.milspecsg.msitemban.api.banrule;

import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.storageservice.DataStorageService;

import java.util.concurrent.CompletableFuture;

public interface BanRuleStorageService<TKey, TBanRule extends BanRule<TKey>> extends DataStorageService<TKey, TBanRule> {

    CompletableFuture<Boolean> delete(String name);

}
