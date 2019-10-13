package rocks.milspecsg.msitemban.commands.banrule;

import com.google.inject.Inject;
import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;

import java.util.Optional;
import java.util.stream.Collectors;

public class ListCommand implements CommandExecutor {

    @Inject
    BanRuleManager<BanRule<?>, ItemStack, Text> banRuleManager;

    @Inject
    BanRuleRepository<String, BanRule<String>, JsonDBOperations, JsonConfig> banRuleStorageService;

    @Override
    public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
        banRuleManager.getPrimaryStorageService().getAllIds();

        banRuleStorageService.getAllIds().thenAcceptAsync(ids -> {
            source.sendMessage(Text.of(String.join(",\n", ids)));
        });
        return CommandResult.success();
    }
}
