package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenPalm;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates palm trees during chunk gen. Palm trees can grow in temperate or hot ocean or sandy beach biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenPalm extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenPalm();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreePalm;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return !BiomeDictionary.isBiomeOfType(biome, Type.COLD) && (BiomeDictionary.isBiomeOfType(biome, Type.OCEAN)
           || (BiomeDictionary.isBiomeOfType(biome, Type.BEACH) && BiomeDictionary.isBiomeOfType(biome, Type.SANDY)));
   }

   @Override
   public boolean canSpawnRandom(Random random)
   {
      return 0 == random.nextInt(20);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
