package rocks.milspecsg.msitemban;

import com.google.common.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import io.jsondb.JsonDBOperations;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.model.data.core.banrule.BanRule;
import rocks.milspecsg.msitemban.service.common.banrule.CommonBanRuleManager;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonJsonBanRuleRepository;
import rocks.milspecsg.msitemban.service.common.banrule.repository.CommonMongoBanRuleRepository;
import rocks.milspecsg.msitemban.service.config.ConfigKeys;
import rocks.milspecsg.msrepository.BindingExtensions;
import rocks.milspecsg.msrepository.api.manager.annotation.JsonRepo;
import rocks.milspecsg.msrepository.api.manager.annotation.MongoRepo;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;
import rocks.milspecsg.msrepository.datastore.json.JsonContext;
import rocks.milspecsg.msrepository.datastore.mongodb.MongoConfig;
import rocks.milspecsg.msrepository.datastore.mongodb.MongoContext;

@SuppressWarnings({"unchecked", "UnstableApiUsage"})
public class CommonModule<TItemStack,
    TMongoBanRule extends BanRule<ObjectId>,
    TJsonBanRule extends BanRule<String>,
    TString> extends AbstractModule {

    @Override
    protected void configure() {

        BindingExtensions be = new BindingExtensions(binder());

        be.bind(
            new TypeToken<BanRuleRepository<?, ?, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<?, BanRule<?>, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<ObjectId, BanRule<ObjectId>, Datastore, MongoConfig>>(getClass()) {
            },
            new TypeToken<CommonMongoBanRuleRepository<TMongoBanRule>>(getClass()) {
            },
            MongoRepo.class
        );

        be.bind(
            new TypeToken<BanRuleRepository<?, ?, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<?, BanRule<?>, ?, ?>>(getClass()) {
            },
            new TypeToken<BanRuleRepository<String, BanRule<String>, JsonDBOperations, JsonConfig>>(getClass()) {
            },
            new TypeToken<CommonJsonBanRuleRepository<TJsonBanRule>>(getClass()) {
            },
            JsonRepo.class
        );

        be.bind(
            new TypeToken<BanRuleManager<BanRule<?>, TItemStack, TString>>(getClass()) {
            },
            new TypeToken<CommonBanRuleManager<BanRule<?>, TItemStack, TString>>(getClass()) {
            }
        );

        bind(MongoConfig.class).toInstance(
            new MongoConfig(
                "rocks.milspecsg.msitemban.model.data.core",
                ConfigKeys.DATA_STORE_NAME,
                ConfigKeys.MONGODB_HOSTNAME,
                ConfigKeys.MONGODB_PORT,
                ConfigKeys.MONGODB_DBNAME,
                ConfigKeys.MONGODB_USERNAME,
                ConfigKeys.MONGODB_PASSWORD,
                ConfigKeys.MONGODB_USE_AUTH
            )
        );

        bind(JsonConfig.class).toInstance(
            new JsonConfig(
                "rocks.milspecsg.msitemban.model.data.core",
                ConfigKeys.DATA_STORE_NAME
            )
        );

        bind(new TypeLiteral<DataStoreContext<ObjectId, Datastore, MongoConfig>>() {
        }).to(new TypeLiteral<MongoContext>() {
        });

        bind(new TypeLiteral<DataStoreContext<String, JsonDBOperations, JsonConfig>>() {
        }).to(new TypeLiteral<JsonContext>() {
        });

    }
}
