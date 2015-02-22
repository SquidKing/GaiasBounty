package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenPecan;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates pecan trees during chunk gen. Pecan trees can grow in temperate or hot non-jungle, non-savannah forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenPecan extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenPecan();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && !(BiomeDictionary.isBiomeOfType(biome, Type.COLD)
          || BiomeDictionary.isBiomeOfType(biome, Type.WET) || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA)
          || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE));
   }

   @Override
   public boolean canDoSpawn(Random random)
   {
      return 0 == random.nextInt(35);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
