package rocks.milspecsg.msitemban.api.banrule;

import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.api.manager.Manager;

import java.util.concurrent.CompletableFuture;

public interface BanRuleManager<TBanRule extends BanRule<?>, TItemStack, TString>
    extends Manager<TBanRule, BanRuleRepository<?, TBanRule, ?>> {

    default String getDefaultIdentifierSingularUpper() {
        return "Rule";
    }

    default String getDefaultIdentifierPluralUpper() {
        return "Rules";
    }

    default String getDefaultIdentifierSingularLower() {
        return "rules";
    }

    default String getDefaultIdentifierPluralLower() {
        return "rules";
    }

    CompletableFuture<TString> create(String name);

    CompletableFuture<TString> delete(String name);

    /**
     * @return Whether the provided item stack is allowed
     */
    boolean check(TItemStack itemStack);

}
