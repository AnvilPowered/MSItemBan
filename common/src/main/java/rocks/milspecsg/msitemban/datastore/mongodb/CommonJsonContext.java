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
//
//        List<String> secretAnnotatedFieldNames = new ArrayList<String>();
//        Map<String, Method> getterMethodMap = new TreeMap<String, Method>();
//        Map<String, Method> setterMethodMap = new TreeMap<String, Method>();
//
//        String idAnnotatedFieldName = null;
//        Method idAnnotatedFieldGetterMethod;
//        Method idAnnotatedFieldSetterMethod;
//
//        Class<?> clazz = JsonDbo.class;
//        List<Field[]> fields = new ArrayList<>();
//        Field[] startFields = clazz.getDeclaredFields();
//        int totalFields = startFields.length;
//        fields.add(startFields);
//        while (clazz.getSuperclass() != Object.class) {
//            clazz = clazz.getSuperclass();
//            Field[] toAdd = clazz.getDeclaredFields();
//            totalFields += toAdd.length;
//            fields.add(toAdd);
//        }
//
//        int x = 0;
//        Field[] fs = new Field[totalFields];
//        for (Field[] field : fields) {
//            for (Field value : field) {
//                fs[x] = value;
//                x++;
//            }
//        }
//
//        Method[] ms = clazz.getDeclaredMethods();
//        for (Field f : fs) {
//            String fieldName = f.getName();
//            System.out.println("Field: " + fieldName);
//            Annotation[] annotations = f.getDeclaredAnnotations();
//            for (Annotation a : annotations) {
//                if (a.annotationType().equals(Id.class)) {
//                    System.out.println("ID Annotation " + a.toString());
//                    System.out.println("ID Field " + f.getName());
//
//                    //We expect only one @Id annotated field and only one corresponding getter for it
//                    //This logic will capture the last @Id annotated field if there are more than one.
//                    idAnnotatedFieldName = fieldName;
//                }
//                if (a.annotationType().equals(Secret.class)) {
//                    secretAnnotatedFieldNames.add(fieldName);
//                }
//            }
//
//            String getterMethodName = formGetterMethodName(f);
//            String setterMethodName = formSetterMethodName(f);
//            for (Method m : ms) {
//                if (m.getName().equals(getterMethodName)) {
//                    getterMethodMap.put(fieldName, m);
//                }
//                if (m.getName().equals(setterMethodName)) {
//                    setterMethodMap.put(fieldName, m);
//                }
//            }
//        }
//        getterMethodMap.get(idAnnotatedFieldName);
//        setterMethodMap.get(idAnnotatedFieldName);

        init("rocks.milspecsg.msitemban.model.data.core", 0, Paths.get("msitemban/data/json").toString(), null, null, false);
    }

    @Override
    protected void initCollections(JsonDBOperations dataStore) {
        dataStore.createCollection(JsonBanRule.class);
    }
}
