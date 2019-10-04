package rocks.milspecsg.msitemban.commands;

import com.google.inject.Inject;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import rocks.milspecsg.msitemban.commands.banrule.CreateCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBanCommandManager implements CommandManager {

    @Inject
    CreateCommand createCommand;

    public static Map<List<String>, CommandSpec> subCommands = new HashMap<>();

    @Override
    public void register(Object plugin) {
        Map<List<String>, CommandSpec> subCommands = new HashMap<>();

        subCommands.put(Arrays.asList("create", "c"), CommandSpec.builder()
            .description(Text.of("Creates a new ban rule"))
            .arguments(
                GenericArguments.string(Text.of("name"))
            )
            .executor(createCommand)
            .build()
        );

        CommandSpec mainCommand = CommandSpec.builder()
            .description(Text.of("Displays all available ban rule sub commands."))
            .children(subCommands)
            .build();

        Sponge.getCommandManager().register(plugin, mainCommand, "banrule", "br");
        ItemBanCommandManager.subCommands = subCommands;

    }
}
