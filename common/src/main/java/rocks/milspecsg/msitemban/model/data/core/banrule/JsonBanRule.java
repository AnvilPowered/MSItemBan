package rocks.milspecsg.msitemban.model.data.core.banrule;

import io.jsondb.annotation.Document;
import rocks.milspecsg.msitemban.model.data.core.serializeditemstack.SerializedItemStack;
import rocks.milspecsg.msrepository.model.data.dbo.JsonDbo;

import java.util.List;

@Document(collection = "rules", schemaVersion = "1.0")
public class JsonBanRule extends JsonDbo implements BanRule<String> {

    private String name;
    private List<SerializedItemStack> itemStacks;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        prePersist();
    }

    @Override
    public List<SerializedItemStack> getItemStacks() {
        return itemStacks;
    }

    @Override
    public void setItemStacks(List<SerializedItemStack> itemStacks) {
        this.itemStacks = itemStacks;
        prePersist();
    }
}
