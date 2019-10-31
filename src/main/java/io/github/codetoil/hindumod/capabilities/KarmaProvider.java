package io.github.codetoil.hindumod.capabilities;

import io.github.codetoil.hindumod.HinduMod;
import io.github.codetoil.hindumod.Karma;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class KarmaProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(Karma.class)
    public static Capability<Karma> KARMA_CAPABILITY;
    public static final ResourceLocation name = new ResourceLocation(HinduMod.MODID,"karma");

    private Karma instance = KARMA_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == KARMA_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == KARMA_CAPABILITY ? KARMA_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return KARMA_CAPABILITY.getStorage().writeNBT(KARMA_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        KARMA_CAPABILITY.getStorage().readNBT(KARMA_CAPABILITY, this.instance, null, nbt);
    }
}
