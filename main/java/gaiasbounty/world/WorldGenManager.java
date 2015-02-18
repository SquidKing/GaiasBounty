package gaiasbounty.world;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Handles all world generation. This includes placement of all plants and buildings during chunk gen, as well as
 * sapling growth algorithms.
 * 
 * @author Alex Smith
 */
public class WorldGenManager
{  
   public static void init()
   {
      addWorldGenFeatures();
   }
   
   private static void addWorldGenFeatures()
   {
      if (ConfigManager.canGenTreeApple)
         GameRegistry.registerWorldGenerator(new WorldGenApple(), 5);
      if (ConfigManager.canGenTreePeach)
         GameRegistry.registerWorldGenerator(new WorldGenPeach(), 5);
      if (ConfigManager.canGenTreeCherry)
         GameRegistry.registerWorldGenerator(new WorldGenCherry(), 5);
      if (ConfigManager.canGenTreeBanana)
         GameRegistry.registerWorldGenerator(new WorldGenBanana(), 5);
      if (ConfigManager.canGenTreeMesquite)
         GameRegistry.registerWorldGenerator(new WorldGenMesquite(), 5);
   }
}
