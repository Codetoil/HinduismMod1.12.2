package io.github.codetoil.hindumod;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

@Mod(modid = HinduMod.MODID, name = HinduMod.NAME, version = HinduMod.VERSION)
public class HinduMod {
    public static final String MODID = "hindumod";
    public static final String NAME = "HinduMod";
    public static final String VERSION = "0.0.0.0";
    public static Side side = FMLCommonHandler.instance().getSide();

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        io.github.codetoil.hindumod.EventHandler.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        CapabilityManager.INSTANCE.register(Karma.class, new Karma.KarmaStorage(), Karma::new);
    }
}
