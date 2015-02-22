package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenMacadamia;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates macadamia trees during chunk gen. Macadamia trees can grow in hot, wet forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenMacadamia extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenMacadamia();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && BiomeDictionary.isBiomeOfType(biome, Type.HOT)
               && BiomeDictionary.isBiomeOfType(biome, Type.WET);
   }

   @Override
   public boolean canDoSpawn(Random random)
   {
      return 0 == random.nextInt(30);
   }

   @Override
   protected WorldGenerator getGenerator()
   {
      return GENERATOR;
   }
}
