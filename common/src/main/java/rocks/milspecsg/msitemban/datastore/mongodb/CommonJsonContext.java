package rocks.milspecsg.msitemban.datastore.mongodb;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.jsondb.CollectionMetaData;
import io.jsondb.JsonDBOperations;
import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import rocks.milspecsg.msitemban.model.data.core.banrule.JsonBanRule;
import rocks.milspecsg.msitemban.service.config.ConfigKeys;
import rocks.milspecsg.msrepository.api.config.ConfigurationService;
import rocks.milspecsg.msrepository.datastore.json.JsonContext;
import rocks.milspecsg.msrepository.model.data.dbo.JsonDbo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.*;

@Singleton
public class CommonJsonContext extends JsonContext {

    private ConfigurationService configurationService;

    @Inject
    public CommonJsonContext(ConfigurationService configurationService) {
        this.configurationService = configurationService;
        configurationService.addConfigLoadedListener(this::loadConfig);
    }

    private void loadConfig(Object plugin) {
        if (!configurationService.getConfigString(ConfigKeys.DATA_STORE_NAME).equalsIgnoreCase("json")) {
            return;
        }

        init("rocks.milspecsg.msitemban.model.data.core", 0, Paths.get("msitemban/data/json").toString(), null, null, false);
    }

    @Override
    protected void initCollections(JsonDBOperations dataStore) {
        if (!dataStore.collectionExists(JsonBanRule.class)) {
            dataStore.createCollection(JsonBanRule.class);
        }
    }
}
