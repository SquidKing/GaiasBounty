package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenCherry;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates cherry trees during chunk gen. Cherry trees can grow in temperate or cold hill or mountain biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenCherry extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenCherry();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreeCherry;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return (BiomeDictionary.isBiomeOfType(biome, Type.HILLS) || BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN))
          && !BiomeDictionary.isBiomeOfType(biome, Type.HOT);
   }

   @Override
   public boolean canSpawnRandom(Random random)
   {
      return 0 == random.nextInt(30);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
