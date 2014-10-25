package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenManager
{  
   public static void init()
   {
      addWorldGenFeatures();
   }
   
   private static void addWorldGenFeatures()
   {
      if (ConfigManager.canGenTreeMesquite)
         GameRegistry.registerWorldGenerator(new WorldGenMesquite(), 5);
   }
}
