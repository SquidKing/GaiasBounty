package com.squidpalace.gaiasbounty.entity;

import com.squidpalace.gaiasbounty.lib.Reference;
import com.squidpalace.gaiasbounty.item.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDuck extends EntityAnimal
{
    public float fallDist;
    public float destPos;
    public float destPosPrev;
    public float fallDistPrev;
    public float fallRate = 1.0F;

    public EntityDuck(World world)
    {
        super(world);
        this.setSize(0.3F, 0.7F);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class,
                6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
                4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.25D);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.fallDistPrev = this.fallDist;
        this.destPosPrev = this.destPos;
        this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);

        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.fallRate < 1.0F)
        {
            this.fallRate = 1.0F;
        }

        this.fallRate = (float) ((double) this.fallRate * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.fallDist += this.fallRate * 2.0F;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float f) {}

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound()
    {
        return Reference.GB_AUDIO_PREFIX + "mob.duck.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Reference.GB_AUDIO_PREFIX + "mob.duck.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return Reference.GB_AUDIO_PREFIX + "mob.duck.hurt";
    }

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_,
                                 int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
   /*protected float getSoundVolume()
   {
      return 0.4F;
   }*/
    protected Item getDropItem()
    {
        return Items.feather;
    }

    /**
     * Drop 0-2 items of this living's type.
     *
     * @param hitByPlayer - Whether this entity has recently been hit by a player.
     * @param looting     - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean hitByPlayer, int looting)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + looting);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Items.feather, 1);
        }

        if (this.isBurning())
        {
            this.entityDropItem(new ItemStack(ItemManager.meat, 1, 9), 0.0F);
        } else
        {
            this.entityDropItem(new ItemStack(ItemManager.meat, 1, 8), 0.0F);
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        return new EntityDuck(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed
     * it (wheat, carrots or seeds depending on the animal type)
     *
     * @param stack - ItemStack representing the breeding item
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack != null && stack.getItem() == Items.wheat;
    }
}
