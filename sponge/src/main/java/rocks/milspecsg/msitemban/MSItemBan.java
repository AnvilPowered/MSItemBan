package rocks.milspecsg.msitemban;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import rocks.milspecsg.msitemban.commands.ItemBanCommandManager;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;
import rocks.milspecsg.msitemban.service.implementation.config.MSConfigurationService;
import rocks.milspecsg.msitemban.service.banrule.ApiBanRuleManager;
import rocks.milspecsg.msitemban.service.banrule.repository.ApiMongoBanRuleRepository;
import rocks.milspecsg.msitemban.service.implementation.banrule.MSSpongeBanRuleManager;
import rocks.milspecsg.msitemban.service.implementation.banrule.repository.MSSpongeMongoBanRuleRepository;
import rocks.milspecsg.msrepository.APIConfigurationModule;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.service.config.ApiConfigurationService;

@Plugin(
    id = MSItemBanPluginInfo.id,
    name = MSItemBanPluginInfo.name,
    version = MSItemBanPluginInfo.version,
    description = MSItemBanPluginInfo.description,
    authors = MSItemBanPluginInfo.authors,
    url = MSItemBanPluginInfo.url
)public class MSItemBan {
    @Override
    public String toString() {
        return MSItemBanPluginInfo.id;
    }

    @Inject
    public Injector spongeRootInjector;

    @Inject
    Logger logger;

    @Inject
    private PluginContainer pluginContainer;

    public static MSItemBan plugin = null;
    private Injector injector = null;

    private boolean alreadyLoadedOnce = false;

    @Listener
    public void onServerInitialization(GameInitializationEvent event) {
        plugin = this;
        Sponge.getServer().getConsole().sendMessage(Text.of(MSItemBanPluginInfo.pluginPrefix, TextColors.YELLOW, "Loading..."));
        initServices();
        initSingletonServices();
        initListeners();
        initCommands();

        loadConfig();
        Sponge.getServer().getConsole().sendMessage(Text.of(MSItemBanPluginInfo.pluginPrefix, TextColors.YELLOW, "Done"));
    }

    @Listener
    public void reload(GameReloadEvent event) {

        loadConfig();
        logger.info("Reloaded successfully!");
    }

    @Listener
    public void stop(GameStoppingEvent event) {
        Sponge.getServer().getConsole().sendMessage(Text.of(MSItemBanPluginInfo.pluginPrefix, TextColors.YELLOW, "Stopping..."));
        logger.info("Saving all players on server");


        removeListeners();
        logger.info("Unregistered listeners");

        stopTasks();
        logger.info("Stopped tasks");

        Sponge.getServer().getConsole().sendMessage(Text.of(MSItemBanPluginInfo.pluginPrefix, TextColors.YELLOW, "Done"));
    }

    private void loadConfig() {
        injector.getInstance(ConfigurationService.class).load(this);
    }

    private void initServices() {
        injector = spongeRootInjector.createChildInjector(new MSItemBanConfigurationModule(), new MSItemBanModule());
    }

    private void initSingletonServices() {

    }

    private void initListeners() {
//        Sponge.getEventManager().registerListeners(this, injector.getInstance(PlayerListener.class));
    }

    private void initCommands() {
        if (!alreadyLoadedOnce) {
            injector.getInstance(ItemBanCommandManager.class).register(this);
            alreadyLoadedOnce = true;
        }
    }

    private void removeListeners() {
        Sponge.getEventManager().unregisterPluginListeners(this);
    }

    private void stopTasks() {
        Sponge.getScheduler().getScheduledTasks(this).forEach(Task::cancel);
    }

    private static class MSItemBanConfigurationModule extends APIConfigurationModule {
        @Override
        protected void configure() {
            super.configure();

            bind(new TypeLiteral<ApiConfigurationService>() {
            }).to(new TypeLiteral<MSConfigurationService>() {
            });
        }
    }

    private static class MSItemBanModule extends ApiModule<ItemStack, MongoBanRule> {
        @Override
        protected void configure() {
            super.configure();

//            bind(PlayerListener.class);

//            bind(SpongePluginInfo.class).to(MSItemBanPluginInfo.class);

            bind(new TypeLiteral<ApiMongoBanRuleRepository<MongoBanRule>>() {
            })
                .to(new TypeLiteral<MSSpongeMongoBanRuleRepository>() {
                });

            bind(new TypeLiteral<ApiBanRuleManager<BanRule<?>, ItemStack>>() {
            })
                .to(new TypeLiteral<MSSpongeBanRuleManager<BanRule<?>>>() {
                });

        }
    }
}
