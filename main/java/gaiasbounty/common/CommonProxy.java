package gaiasbounty.common;

import gaiasbounty.GaiasBounty;
import gaiasbounty.block.BlockManager;
import gaiasbounty.config.ConfigManager;
import gaiasbounty.entity.*;
import gaiasbounty.event.EventManager;
import gaiasbounty.item.ItemManager;
import gaiasbounty.mod.ModManager;
import gaiasbounty.potion.PotionGB;
import gaiasbounty.recipe.RecipeManager;
import gaiasbounty.recipe.SmeltingRecipes;
import gaiasbounty.village.VillageManager;
import gaiasbounty.world.gen.WorldGenManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler
{
   public void preInit(FMLPreInitializationEvent event)
   {
      ConfigManager.init(event.getSuggestedConfigurationFile());
      PotionGB.init();
      BlockManager.addBlocks();
      ItemManager.addItems();
      EventManager.init();
      VillageManager.init();
   }
   
   public void init(FMLInitializationEvent event)
   {
      this.registerRenderers();
      EntityManager.registerEntities();
      BlockManager.setBlockMiscData();
      WorldGenManager.init();
      NetworkRegistry.INSTANCE.registerGuiHandler(GaiasBounty.instance, this);
      RecipeManager.init();
   }
   
   public void postInit(FMLPostInitializationEvent event)
   {
      EntityManager.registerEntitySpawn();
      ModManager.init();
   }
   
   public void registerRenderers() {}

   @Override
   public Object getServerGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
   {
      TileEntity tile = world.getTileEntity(x, y, z);
      
      switch (id)
      {
         default:
            return null;
      }
   }

   @Override
   public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
   {
      return null;
   }
}
