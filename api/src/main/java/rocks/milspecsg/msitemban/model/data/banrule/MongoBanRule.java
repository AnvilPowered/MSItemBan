package rocks.milspecsg.msitemban.model.data.banrule;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import rocks.milspecsg.msrepository.model.data.dbo.MongoDbo;

@Entity("rules")
public class MongoBanRule extends MongoDbo implements BanRule<ObjectId> {
}
