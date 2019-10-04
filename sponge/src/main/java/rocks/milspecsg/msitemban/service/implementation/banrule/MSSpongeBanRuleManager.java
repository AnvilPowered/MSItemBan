package rocks.milspecsg.msitemban.service.implementation.banrule;

import com.google.inject.Inject;
import org.spongepowered.api.item.inventory.ItemStack;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.service.banrule.ApiBanRuleManager;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;

public class MSSpongeBanRuleManager<TBanRule extends BanRule<?>> extends ApiBanRuleManager<TBanRule, ItemStack> {

    @Inject
    public MSSpongeBanRuleManager(ConfigurationService configurationService) {
        super(configurationService);
    }

    @Override
    public boolean check(ItemStack itemStack) {
        return false;
    }
}
