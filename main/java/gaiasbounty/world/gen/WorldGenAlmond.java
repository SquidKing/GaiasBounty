package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenAlmond;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates almond trees during chunk gen. Almond trees can grow in temperate or hot normal humidity, non-savannah plains biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenAlmond extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenAlmond();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.PLAINS) && !(BiomeDictionary.isBiomeOfType(biome, Type.COLD)
          || BiomeDictionary.isBiomeOfType(biome, Type.WET) || BiomeDictionary.isBiomeOfType(biome, Type.DRY)
          || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA));
   }

   @Override
   public boolean canDoSpawn(Random random)
   {
      return 0 == random.nextInt(40);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
