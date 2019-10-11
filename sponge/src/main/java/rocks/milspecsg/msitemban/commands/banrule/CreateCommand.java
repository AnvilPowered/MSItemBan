package rocks.milspecsg.msitemban.commands.banrule;

import com.google.inject.Inject;
import com.google.inject.internal.cglib.proxy.$NoOp;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;

import java.util.Optional;
import java.util.stream.Collectors;

public class CreateCommand implements CommandExecutor {

    @Inject
    BanRuleManager<BanRule<?>, ItemStack, Text> banRuleManager;

    @Inject
    BanRuleRepository<ObjectId, BanRule<ObjectId>, Datastore> banRuleRepository;

    @Override
    public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
        Optional<String> optionalName = context.getOne(Text.of("name"));
        if (!optionalName.isPresent()) {
            throw new CommandException(Text.of("Name is required"));
        }

        banRuleManager.create(optionalName.get()).thenAcceptAsync(source::sendMessage);

        banRuleRepository.getAllIds().thenAcceptAsync(ids -> {
            source.sendMessage(Text.of(ids.stream().map(ObjectId::toString).collect(Collectors.joining(","))));
        });
        return CommandResult.success();
    }
}
