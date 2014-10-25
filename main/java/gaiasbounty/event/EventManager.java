package gaiasbounty.event;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gaiasbounty.GaiasBounty;
import gaiasbounty.block.*;
import gaiasbounty.item.ItemManager;
import gaiasbounty.item.ItemToolGeneric;
import gaiasbounty.lib.Reference;
import gaiasbounty.potion.PotionGB;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class EventManager
{
   public static final EventManager INSTANCE = new EventManager();
   
   private EventManager() {}
   
   public static void init()
   {
      MinecraftForge.EVENT_BUS.register(INSTANCE);
      //FMLCommonHandler.instance().bus().register(INSTANCE);
   }
   
   @SubscribeEvent
   public void fertilize(BonemealEvent event)
   {
      Block block = event.world.getBlock(event.x, event.y, event.z);
      if (!event.world.isRemote && block instanceof IFertilizeable)
      {
         if (((IFertilizeable) block).fertilize(event.world, event.world.rand,
                  event.x, event.y, event.z)) event.setResult(Result.ALLOW);
      }
   }
   
   @SubscribeEvent
   public void entityKilled(LivingDropsEvent event)
   {
      Entity victim = event.entityLiving;
      World world = victim.worldObj;
      double x = victim.posX, y = victim.posY, z = victim.posZ;
      int looting = event.lootingLevel, meta = 0;
      
      if (!world.isRemote)
      {
         if (victim instanceof EntitySquid)
         {
            meta = victim.isBurning() ? 1 : 0;
            event.drops.add(new EntityItem(world, x, y, z,
                     new ItemStack(ItemManager.seafood, 1, meta)));
         }
         else if (victim instanceof EntitySheep)
         {
            if (((EntitySheep) victim).getGrowingAge() >= 0
                     && !(event.source.getEntity() instanceof EntityWolf))
            {
               meta = victim.isBurning() ? 13 : 12;
               int numOfDrops = 1 + world.rand.nextInt(3)
                        + world.rand.nextInt(1 + looting);
               
               for (int i = 0; i < numOfDrops; ++i)
                  event.drops.add(new EntityItem(world, x, y, z,
                           new ItemStack(ItemManager.meat, 1, meta)));
            }
         }
         else if (victim instanceof EntityHorse)
         {
            if (((EntityHorse) victim).getGrowingAge() >= 0
                     && !(event.source.getEntity() instanceof EntityWolf))
            {
               meta = victim.isBurning() ? 1 : 0;
               int numOfDrops = 1 + world.rand.nextInt(3)
                        + world.rand.nextInt(1 + looting);
               
               for (int i = 0; i < numOfDrops; ++i)
                  event.drops.add(new EntityItem(world, x, y, z,
                           new ItemStack(ItemManager.meat, 1, meta)));
            }
         }
         else if (victim instanceof EntityPig)
         {
            if (((EntityPig) victim).getGrowingAge() >= 0)
            {
               meta = victim.isBurning() ? 3 : 2;
               int numOfDrops = world.rand.nextInt(2)
                        + world.rand.nextInt(1 + looting)
                        + (world.rand.nextInt(5) == 0 ? 1 : 0);
               
               for (int i = 0; i < numOfDrops; ++i)
                  event.drops.add(new EntityItem(world, x, y, z,
                           new ItemStack(ItemManager.meat, 1, meta)));
            }
         }
      }
   }
   
   @SubscribeEvent
   public void itemPickedUp(EntityItemPickupEvent event)
   {  
      
   }
   
   @SubscribeEvent
   public void itemBroken(PlayerDestroyItemEvent event)
   {
      Item breakItem = event.original.getItem();
      if (breakItem instanceof ItemToolGeneric)
         event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer,
                  "minecraft:random.break", 1.0F, 1.0F);
   }
   
   @SubscribeEvent
   public void entityUpdate(LivingUpdateEvent event)
   {
      EntityLivingBase entity = event.entityLiving;
      World world = entity.worldObj;
      
      if (entity.isPotionActive(PotionGB.gas))
      {
         if (world.rand.nextInt(200 / 1 +
                  entity.getActivePotionEffect(PotionGB.gas).getAmplifier()) == 0)
         {
            world.playSoundAtEntity(entity, Reference.GB_AUDIO_PREFIX
                     + "effect.gas", 1.0F, 1.0F);
            AxisAlignedBB searchBox = AxisAlignedBB.getBoundingBox(entity.posX - 4.0F,
                     entity.posY - 4.0F, entity.posZ - 4.0F, entity.posX + 4.0F,
                     entity.posY + 4.0F, entity.posZ + 4.0F);
            List foundEntities = world.getEntitiesWithinAABB(EntityPlayer.class, searchBox);
            for (int i = 0; i < foundEntities.size(); ++i)
            {
               if (world.rand.nextBoolean() && foundEntities.get(i) != entity)
                  ((EntityPlayer)foundEntities.get(i))
                     .addPotionEffect(new PotionEffect(Potion.confusion.id, 160, 0));
            }
            
            foundEntities = world.getEntitiesWithinAABB(EntityAnimal.class, searchBox);
            for (int i = 0; i < foundEntities.size(); ++i)
            {
               ((EntityAnimal)foundEntities.get(i))
                  .attackEntityFrom(DamageSource.causeMobDamage(entity), 0.0F);
            }
         }
      }
   }
   
   /*@SubscribeEvent
   public void itemCrafted(ItemCraftedEvent event)
   {
      for (int i = 0; i < event.craftMatrix.getSizeInventory(); ++i)
      {
         if (event.craftMatrix.getStackInSlot(i) != null)
         {
            ItemStack stack = event.craftMatrix.getStackInSlot(i);
            
            if (stack.getItem() != null && stack.getItem() == ItemManager.knife)
            {
               ItemStack newStack = new ItemStack(stack.getItem(), 1, stack.getItemDamage() + 1);
               if (newStack.getItemDamage() >= newStack.getItem().getMaxDamage())
                  newStack.stackSize--;
               event.craftMatrix.setInventorySlotContents(i, newStack);
            }
         }
      }
   }*/
}
