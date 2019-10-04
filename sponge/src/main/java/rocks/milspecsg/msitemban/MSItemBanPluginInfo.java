package rocks.milspecsg.msitemban;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import rocks.milspecsg.msrepository.SpongePluginInfo;

public class MSItemBanPluginInfo implements SpongePluginInfo {
    public static final String id = "msitemban";
    public static final String name = "MSItemBan";
    public static final String version = "0.1.0-SNAPSHOT";
    public static final String description = "A plugin to ban items";
    public static final String url = "https://github.com/MilSpecSG/MSItemBan";
    public static final String authors = "Cableguy20";
    public static final Text pluginPrefix = Text.of(TextColors.GREEN, "[MSItemBan] ");

    @Override
    public Text getPrefix() {
        return pluginPrefix;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public String getAuthors() {
        return authors;
    }
}
