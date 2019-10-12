package rocks.milspecsg.msitemban.model.data.core.serializeditemstack;

import java.util.Map;

/**
 * Represents an abstract SerializedItemStack in data storage
 */
public interface SerializedItemStack {

    void setProperties(Map<String, Object> properties);

    Map<String, Object> getProperties();

}
