package rocks.milspecsg.msitemban.model.data.core.serializeditemstack;

import com.google.common.collect.ImmutableMap;
import rocks.milspecsg.msitemban.model.data.core.serializeditemstack.SerializedItemStack;

import java.util.Map;

public class JsonSerializedItemStack implements SerializedItemStack {

    private Map<String, Object> properties;

    @Override
    public Map<String, Object> getProperties() {
        return ImmutableMap.copyOf(properties);
    }

    @Override
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
