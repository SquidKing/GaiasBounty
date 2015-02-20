package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenLemon;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Creates lemon trees during chunk gen. Lemon trees can grow in jungle or river biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenLemon implements IWorldGenerator
{
   private static final WorldGenerator generator = new TreeGenLemon();

   @Override
   public void generate(Random rand, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      BiomeGenBase biome = world.getBiomeGenForCoords(chunkX * 16 + 8,
               chunkZ * 16 + 8);

      if (rand.nextInt(30) == 0 && (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)
    		                    || BiomeDictionary.isBiomeOfType(biome, Type.RIVER)))
      {
         int x, y, z;
         
         for (int i = 0; i < 20; i++)
         {
            x = chunkX * 16 + rand.nextInt(16);
            z = chunkZ * 16 + rand.nextInt(16);
            y = world.getTopSolidOrLiquidBlock(x, z) - 1;

            if (generator.generate(world, rand, x, y + 1, z))
            {
               break;
            }
         }
      }
   }
}
