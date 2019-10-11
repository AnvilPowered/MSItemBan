package rocks.milspecsg.msitemban.model.data.banrule;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import rocks.milspecsg.msitemban.model.data.serializeditemstack.SerializedItemStack;
import rocks.milspecsg.msrepository.model.data.dbo.MongoDbo;

import java.util.List;

@Entity("rules")
public class MongoBanRule extends MongoDbo implements BanRule<ObjectId> {

    private String name;
    private List<SerializedItemStack> itemStacks;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<SerializedItemStack> getItemStacks() {
        return itemStacks;
    }

    @Override
    public void setItemStacks(List<SerializedItemStack> itemStacks) {
        this.itemStacks = itemStacks;
    }
}
