package rocks.milspecsg.msitemban.service.sponge.banrule;

import com.google.inject.Inject;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.service.common.banrule.CommonBanRuleManager;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;

public class MSSpongeBanRuleManager<TBanRule extends BanRule<?>> extends CommonBanRuleManager<TBanRule, ItemStack, Text> {

    @Inject
    public MSSpongeBanRuleManager(ConfigurationService configurationService) {
        super(configurationService);
    }

    @Override
    public boolean check(ItemStack itemStack) {
        return false;
    }
}
