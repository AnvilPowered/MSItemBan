package rocks.milspecsg.msitemban.datastore.mongodb;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.DefaultCreator;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;
import rocks.milspecsg.msitemban.service.config.ConfigKeys;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.datastore.mongodb.MongoContext;

@Singleton
public class ApiMongoContext extends MongoContext {

    private ConfigurationService configurationService;

    @Inject
    public ApiMongoContext(ConfigurationService configurationService) {
        this.configurationService = configurationService;
        configurationService.addConfigLoadedListener(this::loadConfig);
    }

    private void loadConfig(Object plugin) {
        String hostname = configurationService.getConfigString(ConfigKeys.MONGODB_HOSTNAME);
        int port = configurationService.getConfigInteger(ConfigKeys.MONGODB_PORT);
        String dbName = configurationService.getConfigString(ConfigKeys.MONGODB_DBNAME);
        String username = configurationService.getConfigString(ConfigKeys.MONGODB_USERNAME);
        String password = configurationService.getConfigString(ConfigKeys.MONGODB_PASSWORD);
        boolean useAuth = configurationService.getConfigBoolean(ConfigKeys.MONGODB_USE_AUTH);

        init(hostname, port, dbName, username, password, useAuth);
    }

    @Override
    protected void initMorphiaMaps(Morphia morphia) {
        morphia.map(
            MongoBanRule.class
        );

        morphia.getMapper().getOptions().setObjectFactory(new DefaultCreator() {
            @Override
            protected ClassLoader getClassLoaderForClass() {
                return ApiMongoContext.this.getClass().getClassLoader();
            }
        });
    }
}
