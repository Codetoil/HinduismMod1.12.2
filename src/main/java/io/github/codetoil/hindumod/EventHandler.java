package io.github.codetoil.hindumod;

import io.github.codetoil.hindumod.capabilities.KarmaProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    @SubscribeEvent
    public static void onCapabilityAttach(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase) event.getObject();
            event.addCapability(KarmaProvider.name, entity);
        }
    }

    @SubscribeEvent
    public static void onReincarnation(PlayerEvent.Clone event)
    {
        Karma from = event.getOriginal().getCapability(KarmaProvider.KARMA_CAPABILITY, null);
        Karma to = event.getEntityLiving().getCapability(KarmaProvider.KARMA_CAPABILITY, null);
        assert from != null;
        assert to != null;
        to.setKarma(from.getKarma());
        if (!event.isWasDeath())
        {
            //reincarate
        }
    }
}
