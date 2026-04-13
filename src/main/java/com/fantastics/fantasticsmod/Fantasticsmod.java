package com.fantastics.fantasticsmod;

import com.fantastics.fantasticsmod.init.BlockInit;
import com.fantastics.fantasticsmod.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Fantasticsmod.MODID)
public class Fantasticsmod {
    public static final String MODID = "fantasticsmod";

    public Fantasticsmod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
    }
}
