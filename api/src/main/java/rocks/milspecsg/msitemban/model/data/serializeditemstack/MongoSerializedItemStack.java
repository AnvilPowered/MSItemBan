package rocks.milspecsg.msitemban.model.data.serializeditemstack;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import rocks.milspecsg.msrepository.model.data.dbo.MongoDbo;

import java.util.Map;

@Embedded
public class MongoSerializedItemStack extends MongoDbo implements SerializedItemStack<ObjectId> {

    private Map<String, Object> properties;

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

}
