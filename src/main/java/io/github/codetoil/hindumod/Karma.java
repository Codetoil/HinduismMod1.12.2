package io.github.codetoil.hindumod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class Karma {
    // Entity we have the karma of
    private EntityLivingBase entity;

    // The actual karma of the entity
    private double karma = 0;

    public Karma(EntityLivingBase entity)
    {
        this.entity = entity;
    }

    Karma()
    {

    }

    public void setEntity(EntityLivingBase entity) {
        if (this.entity != null) {
            this.entity = entity;
        }
        else
        {
            throw new RuntimeException("Entity already set!!");
        }
    }

    public double getKarma() {
        return karma;
    }

    public void addKarma(double amount)
    {
        karma += amount;
    }

    public EntityLivingBase getEntity() {
        return entity;
    }

    public void setKarma(double karma) {
        this.karma = karma;
    }

    public static class KarmaStorage implements Capability.IStorage<Karma> {
        @Nullable
        @Override
        public NBTBase writeNBT(Capability<Karma> capability, Karma instance, EnumFacing side) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setDouble("karma", instance.getKarma());
            return nbt;
        }

        @Override
        public void readNBT(Capability<Karma> capability, Karma instance, EnumFacing side, NBTBase nbt) {
            if (nbt instanceof NBTTagCompound)
            {
                if (((NBTTagCompound) nbt).hasKey("karma", Constants.NBT.TAG_DOUBLE))
                {
                    instance.setKarma(((NBTTagCompound) nbt).getDouble("karma"));
                }
                else
                {
                    throw new IllegalArgumentException("Karma has no double named \"karma\"!!");
                }
            }
            else
            {
                throw new IllegalArgumentException("Karma is not an Compound tag!! It is a(n) " + nbt.getClass().getName() + " instead!!");
            }
        }
    }
}
