package rocks.milspecsg.msitemban.api.banrule.repository;

import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.Repository;

import java.util.concurrent.CompletableFuture;

public interface BanRuleRepository<TKey, TBanRule extends BanRule<TKey>> extends Repository<TKey, TBanRule> {

    CompletableFuture<Boolean> deleteOne(String name);
}
