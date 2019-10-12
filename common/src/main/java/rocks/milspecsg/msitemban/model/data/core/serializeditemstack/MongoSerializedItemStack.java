package rocks.milspecsg.msitemban.model.data.core.serializeditemstack;

import com.google.common.collect.ImmutableMap;
import org.mongodb.morphia.annotations.Embedded;
import rocks.milspecsg.msitemban.model.data.core.serializeditemstack.SerializedItemStack;

import java.util.Map;

@Embedded
public class MongoSerializedItemStack implements SerializedItemStack {

    private Map<String, Object> properties;

    @Override
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Object> getProperties() {
        return ImmutableMap.copyOf(properties);
    }

}
