package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenLime;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates lime trees during chunk gen. Lime trees can grow in ocean or swamp biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenLime extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenLime();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreeLime;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.OCEAN) || BiomeDictionary.isBiomeOfType(biome, Type.SWAMP);
   }

   @Override
   public boolean canSpawnRandom(Random random)
   {
      return 0 == random.nextInt(35);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
