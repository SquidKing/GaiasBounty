package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenPeach;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates peach trees during chunk gen. Peach trees can grow in swamp biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenPeach extends WorldGenTreeBase
{
   private static final WorldGenerator GENERATOR = new TreeGenPeach();

   @Override
   public boolean isValidSpawnBiome(BiomeGenBase biome)
   {
      return BiomeDictionary.isBiomeOfType(biome, Type.SWAMP);
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
