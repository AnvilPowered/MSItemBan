package rocks.milspecsg.msitemban.model.data.core.banrule;

import com.google.common.collect.ImmutableList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msitemban.model.data.core.serializeditemstack.SerializedItemStack;
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
        return ImmutableList.copyOf(itemStacks);
    }

    @Override
    public void setItemStacks(List<SerializedItemStack> itemStacks) {
        this.itemStacks = itemStacks;
    }
}
