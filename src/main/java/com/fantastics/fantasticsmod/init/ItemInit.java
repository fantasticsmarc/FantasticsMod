package com.fantastics.fantasticsmod.init;

import com.fantastics.fantasticsmod.Fantasticsmod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    private static final FoodProperties KFC_PROPS = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(4.0F)
            .build();

    private static final FoodProperties FRIED_CHICKEN_PROPS = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.3333333333F)
            .build();

    private static final FoodProperties DONUT_PROPS = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 3), 0.55f)
            .build();

    private static final FoodProperties KEBAB_PROPS = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 1), 0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 3), 0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 3), 0.75f)
            .build();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fantasticsmod.MODID);

    public static final RegistryObject<Item> POKEBALL = ITEMS.register(
            "pokeball", () -> new ThrowablePotionItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant())
    );

    public static final RegistryObject<Item> KFC = ITEMS.register(
            "kfc", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(KFC_PROPS))
    );

    public static final RegistryObject<Item> DONUT = ITEMS.register(
            "donut", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(DONUT_PROPS))
    );

    public static final RegistryObject<Item> KEBAB = ITEMS.register(
            "kebab", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(KEBAB_PROPS))
    );

    public static final RegistryObject<Item> COKE = ITEMS.register(
            "coke", () -> new PotionItem(new Item.Properties().tab(CreativeModeTab.TAB_BREWING).stacksTo(16)) {
                @Override
                public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
                    if (entity instanceof Player) {
                        Player player = (Player) entity;
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    }
                    return super.finishUsingItem(stack, level, entity);
                }
            }
    );

    public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register(
            "fried_chicken", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FRIED_CHICKEN_PROPS))
    );

    public static final RegistryObject<SwordItem> KENTUCKY_FRIED_SWORD = ITEMS.register(
            "kentucky_fried_sword", () -> new SwordItem(Tiers.NETHERITE,
                    6,
                    2F,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))
    );

    public static final RegistryObject<SwordItem> FRIED_SWORD = ITEMS.register(
            "fried_sword", () -> new SwordItem(Tiers.DIAMOND,
                    4,
                    2.5F,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))
    );
}
