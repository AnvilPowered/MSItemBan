package rocks.milspecsg.msitemban;

import com.google.common.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.msitemban.api.banrule.BanRuleManager;
import rocks.milspecsg.msitemban.api.banrule.repository.BanRuleRepository;
import rocks.milspecsg.msitemban.datastore.mongodb.ApiMongoContext;
import rocks.milspecsg.msitemban.model.data.banrule.BanRule;
import rocks.milspecsg.msitemban.model.data.banrule.MongoBanRule;
import rocks.milspecsg.msitemban.service.banrule.ApiBanRuleManager;
import rocks.milspecsg.msitemban.service.banrule.repository.ApiMongoBanRuleRepository;
import rocks.milspecsg.msrepository.BindingExtensions;
import rocks.milspecsg.msrepository.api.manager.annotation.MongoRepo;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

@SuppressWarnings({"unchecked", "UnstableApiUsage"})
public class ApiModule<TItemStack, TMongoBanRule extends BanRule<ObjectId>> extends AbstractModule {

    @Override
    protected void configure() {

        BindingExtensions be = BindingExtensions.getInstance();

        be.bind(
            binder(),
            new TypeToken<BanRuleRepository<?,?>>(getClass()) {},
            new TypeToken<BanRuleRepository<?, BanRule<?>>>(getClass()) {},
            new TypeToken<ApiMongoBanRuleRepository<TMongoBanRule>>(getClass()) {},
            MongoRepo.class
        );


//        bind((TypeLiteral<BanRuleRepository<?, ?>>) TypeLiteral.get(new TypeToken<BanRuleRepository<?, BanRule<?>>>(getClass()) {
//        }.getType())).annotatedWith(MongoRepo.class)
//            .to((TypeLiteral<ApiMongoBanRuleRepository<TMongoBanRule>>) TypeLiteral.get(new TypeToken<ApiMongoBanRuleRepository<TMongoBanRule>>(getClass()) {
//            }.getType()));

        bind((TypeLiteral<BanRuleManager<BanRule<?>, TItemStack>>) TypeLiteral.get(new TypeToken<BanRuleManager<BanRule<?>, TItemStack>>(getClass()) {
        }.getType())).to((TypeLiteral<ApiBanRuleManager<BanRule<?>, TItemStack>>) TypeLiteral.get(new TypeToken<ApiBanRuleManager<BanRule<?>, TItemStack>>(getClass()) {
        }.getType()));

        bind(new TypeLiteral<DataStoreContext<Datastore>>() {
        }).to(new TypeLiteral<ApiMongoContext>() {
        });

    }
}
