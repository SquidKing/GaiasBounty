package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenFig;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates fig trees during chunk gen. Fig trees can grow in river or wet forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenFig extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenFig();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreeFig;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.RIVER) || (BiomeDictionary.isBiomeOfType(biome, Type.FOREST)
          && BiomeDictionary.isBiomeOfType(biome, Type.WET));
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
