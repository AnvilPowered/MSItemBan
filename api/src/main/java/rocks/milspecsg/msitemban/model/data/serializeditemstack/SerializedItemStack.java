package rocks.milspecsg.msitemban.model.data.serializeditemstack;

import rocks.milspecsg.msrepository.model.data.dbo.ObjectWithId;

import java.util.Map;

/**
 * Represents an abstract SerializedItemStack in data storage
 */
public interface SerializedItemStack<TKey> extends ObjectWithId<TKey> {

    Map<String, Object> getProperties();

}
