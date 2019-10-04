package rocks.milspecsg.msitemban.service.implementation.config;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.DefaultConfig;
import rocks.milspecsg.msitemban.service.config.ConfigKeys;
import rocks.milspecsg.msrepository.service.config.ApiConfigurationService;

@Singleton
public class MSConfigurationService extends ApiConfigurationService {

    @Inject
    public MSConfigurationService(@DefaultConfig(sharedRoot = false) ConfigurationLoader<CommentedConfigurationNode> configLoader) {
        super(configLoader);
    }

    @Override
    protected void initNodeTypeMap() {
        nodeTypeMap.put(ConfigKeys.MONGODB_HOSTNAME, new TypeToken<String>() {
        });
        nodeTypeMap.put(ConfigKeys.MONGODB_PORT, new TypeToken<Integer>() {
        });
        nodeTypeMap.put(ConfigKeys.MONGODB_DBNAME, new TypeToken<String>() {
        });
        nodeTypeMap.put(ConfigKeys.MONGODB_USERNAME, new TypeToken<String>() {
        });
        nodeTypeMap.put(ConfigKeys.MONGODB_PASSWORD, new TypeToken<String>() {
        });
        nodeTypeMap.put(ConfigKeys.MONGODB_USE_AUTH, new TypeToken<Boolean>() {
        });
    }

    @Override
    protected void initVerificationMaps() {

    }

    @Override
    protected void initDefaultMaps() {
        defaultStringMap.put(ConfigKeys.MONGODB_HOSTNAME, "localhost");
        defaultIntegerMap.put(ConfigKeys.MONGODB_PORT, 27017);
        defaultStringMap.put(ConfigKeys.MONGODB_DBNAME, "msitemban");
        defaultStringMap.put(ConfigKeys.MONGODB_USERNAME, "admin");
        defaultStringMap.put(ConfigKeys.MONGODB_PASSWORD, "password");
        defaultBooleanMap.put(ConfigKeys.MONGODB_USE_AUTH, false);
    }

    @Override
    protected void initNodeNameMap() {
        nodeNameMap.put(ConfigKeys.MONGODB_HOSTNAME, "mongodb.hostname");
        nodeNameMap.put(ConfigKeys.MONGODB_PORT, "mongodb.port");
        nodeNameMap.put(ConfigKeys.MONGODB_DBNAME, "mongodb.dbName");
        nodeNameMap.put(ConfigKeys.MONGODB_USERNAME, "mongodb.username");
        nodeNameMap.put(ConfigKeys.MONGODB_PASSWORD, "mongodb.password");
        nodeNameMap.put(ConfigKeys.MONGODB_USE_AUTH, "mongodb.useAuth");
    }

    @Override
    protected void initNodeDescriptionMap() {
        nodeDescriptionMap.put(ConfigKeys.MONGODB_HOSTNAME, "\nMongoDB hostname");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_PORT, "\nMongoDB port");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_DBNAME, "\nMongoDB database name");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_USERNAME, "\nMongoDB username");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_PASSWORD, "\nMongoDB password");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_USE_AUTH, "\nWhether to use authentication (username/password) for MongoDB connection");
    }
}
