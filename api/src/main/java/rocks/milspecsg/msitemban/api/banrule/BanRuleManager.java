package rocks.milspecsg.msitemban.api.banrule;

import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.manager.Manager;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BanRuleManager<TKey, TBanRule extends BanRule<TKey>, TItemStack> extends Manager<TKey, TBanRule, BanRuleRepository<TKey, TBanRule>> {

    CompletableFuture<Optional<TBanRule>> create(TBanRule banRule);

    CompletableFuture<Boolean> delete(String name);

    /**
     * @return Whether the provided item stack is allowed
     */
    boolean check(TItemStack itemStack);

}
