package rocks.milspecsg.msitemban.service.sponge.config;

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

    private static TypeToken<String> stringTypeToken = new TypeToken<String>() {
    };
    private static TypeToken<Integer> integerTypeToken = new TypeToken<Integer>() {
    };
    private static TypeToken<Boolean> booleanTypeToken = new TypeToken<Boolean>() {
    };

    @Override
    protected void initNodeTypeMap() {
        nodeTypeMap.put(ConfigKeys.DATA_STORE_NAME, stringTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_HOSTNAME, stringTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_PORT, integerTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_DBNAME, stringTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_USERNAME, stringTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_PASSWORD, stringTypeToken);
        nodeTypeMap.put(ConfigKeys.MONGODB_USE_AUTH, booleanTypeToken);
    }

    @Override
    protected void initVerificationMaps() {

    }

    @Override
    protected void initDefaultMaps() {
        defaultStringMap.put(ConfigKeys.DATA_STORE_NAME, "mongodb");
        defaultStringMap.put(ConfigKeys.MONGODB_HOSTNAME, "localhost");
        defaultIntegerMap.put(ConfigKeys.MONGODB_PORT, 27017);
        defaultStringMap.put(ConfigKeys.MONGODB_DBNAME, "msitemban");
        defaultStringMap.put(ConfigKeys.MONGODB_USERNAME, "admin");
        defaultStringMap.put(ConfigKeys.MONGODB_PASSWORD, "password");
        defaultBooleanMap.put(ConfigKeys.MONGODB_USE_AUTH, false);
    }

    @Override
    protected void initNodeNameMap() {
        nodeNameMap.put(ConfigKeys.DATA_STORE_NAME, "datastore.name");
        nodeNameMap.put(ConfigKeys.MONGODB_HOSTNAME, "datastore.mongodb.hostname");
        nodeNameMap.put(ConfigKeys.MONGODB_PORT, "datastore.mongodb.port");
        nodeNameMap.put(ConfigKeys.MONGODB_DBNAME, "datastore.mongodb.dbName");
        nodeNameMap.put(ConfigKeys.MONGODB_USERNAME, "datastore.mongodb.username");
        nodeNameMap.put(ConfigKeys.MONGODB_PASSWORD, "datastore.mongodb.password");
        nodeNameMap.put(ConfigKeys.MONGODB_USE_AUTH, "datastore.mongodb.useAuth");
    }

    @Override
    protected void initNodeDescriptionMap() {
        nodeDescriptionMap.put(ConfigKeys.DATA_STORE_NAME, "Name for datastore. Available: mongodb, mariadb, json, nitrite, h2");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_HOSTNAME, "\nMongoDB hostname");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_PORT, "\nMongoDB port");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_DBNAME, "\nMongoDB database name");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_USERNAME, "\nMongoDB username");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_PASSWORD, "\nMongoDB password");
        nodeDescriptionMap.put(ConfigKeys.MONGODB_USE_AUTH, "\nWhether to use authentication (username/password) for MongoDB connection");
    }
}
