package io.github.codetoil.hindumod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = HinduMod.MODID, name = HinduMod.NAME, version = HinduMod.VERSION)
public class HinduMod {
    public static final String MODID = "hindumod";
    public static final String NAME = "HinduMod";
    public static final String VERSION = "0.0.0.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
