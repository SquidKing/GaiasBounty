package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenTea;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates tea trees during chunk gen. Tea trees can grow in temperate or hot river, ocean or swamp biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenTea extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenTea();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreeTea;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return (BiomeDictionary.isBiomeOfType(biome, Type.RIVER) || BiomeDictionary.isBiomeOfType(biome, Type.OCEAN)
          || BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) && !BiomeDictionary.isBiomeOfType(biome, Type.COLD);
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
