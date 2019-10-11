package rocks.milspecsg.msitemban.model.data.banrule;

import rocks.milspecsg.msitemban.model.data.serializeditemstack.SerializedItemStack;
import rocks.milspecsg.msrepository.model.data.dbo.ObjectWithId;

import java.util.List;

/**
 * Represents an abstract BanRule in data storage
 *
 * @param <TKey> ID type
 */
public interface BanRule<TKey> extends ObjectWithId<TKey> {

    String getName();
    void setName(String name);

    List<SerializedItemStack> getItemStacks();
    void setItemStacks(List<SerializedItemStack> itemStacks);
}
