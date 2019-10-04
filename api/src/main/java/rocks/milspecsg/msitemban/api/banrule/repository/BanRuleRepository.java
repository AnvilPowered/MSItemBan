package rocks.milspecsg.msitemban.api.banrule.repository;

import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msrepository.api.repository.Repository;

import java.util.concurrent.CompletableFuture;

public interface BanRuleRepository<TKey, TBanRule extends BanRule<TKey>> extends Repository<TKey, TBanRule> {

    default String getDefaultIdentifierSingularUpper() {
        return "Ban Rule";
    }

    default String getDefaultIdentifierPluralUpper() {
        return "Ban Rules";
    }

    default String getDefaultIdentifierSingularLower() {
        return "ban rule";
    }

    default String getDefaultIdentifierPluralLower() {
        return "ban rules";
    }

    CompletableFuture<Boolean> delete(String name);


}
