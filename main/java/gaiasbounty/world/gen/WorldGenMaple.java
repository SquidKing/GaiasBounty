package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenMaple;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates maple trees during chunk gen. Maple trees can grow in temperate or cold non-snowy, non-dry forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenMaple extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenMaple();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && !(BiomeDictionary.isBiomeOfType(biome, Type.HOT)
          || BiomeDictionary.isBiomeOfType(biome, Type.DRY) || BiomeDictionary.isBiomeOfType(biome, Type.SNOWY));
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
