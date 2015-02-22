package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenOlive;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates olive trees during chunk gen. Olive trees can grow in coniferous forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenOlive extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenOlive();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS);
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
