package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenLemon;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates lemon trees during chunk gen. Lemon trees can grow in non-dry hot or temperate jungles, humid forests, or rivers.
 * 
 * @author Alex Smith
 */
public class WorldGenLemon extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenLemon();
   
   @Override
   public boolean isSpawnConfigured()
   {
      return ConfigManager.canGenTreeLemon;
   }

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) || BiomeDictionary.isBiomeOfType(biome, Type.RIVER)
          || (BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && BiomeDictionary.isBiomeOfType(biome, Type.WET))
          && !BiomeDictionary.isBiomeOfType(biome, Type.COLD));
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
