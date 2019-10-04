package rocks.milspecsg.msitemban.commands.banrule;

import com.google.inject.Inject;
import com.google.inject.internal.cglib.proxy.$NoOp;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;

import java.util.Optional;

public class CreateCommand implements CommandExecutor {

    @Inject
    BanRuleManager<BanRule<?>, ItemStack> banRuleManager;

    @Override
    public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
        Optional<String> optionalName = context.getOne(Text.of("name"));
        if (!optionalName.isPresent()) {
            throw new CommandException(Text.of("Name is required"));
        }
        BanRule<?> banRule = banRuleManager.getPrimaryRepository().generateEmpty();
        banRule.setName(optionalName.get());
        banRuleManager.create(banRule).thenAcceptAsync(br -> {
            if (br.isPresent()) {
                source.sendMessage(Text.of(TextColors.GREEN, "Succesfully created banrule ", br.get().getName(), " with id ", br.get().getId()));
            } else {
                source.sendMessage(Text.of(TextColors.RED, "Error creating banrule"));
            }
        });
        return CommandResult.success();
    }
}
