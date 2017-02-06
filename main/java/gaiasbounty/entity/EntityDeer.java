package gaiasbounty.entity;

import gaiasbounty.item.ItemManager;
import gaiasbounty.lib.Reference;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDeer extends EntityAnimal
{
    public boolean hasAntlers = true;

    public EntityDeer(World world)
    {
        super(world);
        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class,
                6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        hasAntlers = world.rand.nextBoolean();
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
                10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.3D);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Reference.GB_AUDIO_PREFIX + "mob.deer.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return Reference.GB_AUDIO_PREFIX + "mob.deer.hurt";
    }

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_,
                                 int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.7F;
    }

    protected Item getDropItem()
    {
        return Items.leather;
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
            this.dropItem(Items.leather, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + looting);

        for (k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.entityDropItem(new ItemStack(ItemManager.meat, 1, 11), 0.0F);
            } else
            {
                this.entityDropItem(new ItemStack(ItemManager.meat, 1, 10), 0.0F);
            }
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        return new EntityDeer(this.worldObj);
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

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.hasAntlers = nbt.getBoolean("HasAntlers");
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("HasAntlers", this.hasAntlers);
    }
}
