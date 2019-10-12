package rocks.milspecsg.msitemban;

import com.google.common.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.datastore.mongodb.CommonJsonContext;
import rocks.milspecsg.msitemban.datastore.mongodb.CommonMongoContext;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msitemban.service.common.banrule.CommonBanRuleManager;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonJsonBanRuleRepository;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonMongoBanRuleRepository;
import rocks.milspecsg.msrepository.BindingExtensions;
import rocks.milspecsg.msrepository.api.manager.annotation.JsonRepo;
import rocks.milspecsg.msrepository.api.manager.annotation.MongoRepo;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

@SuppressWarnings({"unchecked", "UnstableApiUsage"})
public class CommonModule<TItemStack,
    TMongoBanRule extends BanRule<ObjectId>,
    TJsonBanRule extends BanRule<ObjectId>,
    TString> extends AbstractModule {

    @Override
    protected void configure() {

        BindingExtensions be = new BindingExtensions(binder());

        be.bind(
            new TypeToken<BanRuleRepository<?, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<?, BanRule<?>, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<ObjectId, BanRule<ObjectId>, Datastore>>() {
            },
            new TypeToken<CommonMongoBanRuleRepository<TMongoBanRule>>(getClass()) {
            },
            MongoRepo.class
        );

        be.bind(
            new TypeToken<BanRuleRepository<?, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<?, BanRule<?>, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<ObjectId, BanRule<ObjectId>, JsonDBOperations>>() {
            },
            new TypeToken<CommonJsonBanRuleRepository<TJsonBanRule>>(getClass()) {
            },
            JsonRepo.class
        );

        bind(new TypeLiteral<DataStoreContext<Datastore>>() {
        }).to(new TypeLiteral<CommonMongoContext>() {
        });

        bind(new TypeLiteral<DataStoreContext<JsonDBOperations>>() {
        }).to(new TypeLiteral<CommonJsonContext>() {
        });

        be.bind(
            new TypeToken<BanRuleManager<BanRule<?>, TItemStack, TString>>(getClass()) {
            },
            new TypeToken<CommonBanRuleManager<BanRule<?>, TItemStack, TString>>(getClass()) {
            }
        );

    }
}
