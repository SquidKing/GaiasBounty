package gaiasbounty.world.gen;

import gaiasbounty.world.gen.tree.TreeGenApple;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Creates apple trees during chunk gen. Apple trees can grow in non-snowy forest biomes.
 * 
 * @author Alex Smith
 */
public class WorldGenApple implements IWorldGenerator
{
   private static final WorldGenerator generator = new TreeGenApple();
   
   @Override
   public void generate(Random rand, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      BiomeGenBase biome = world.getBiomeGenForCoords(chunkX * 16 + 8,
               chunkZ * 16 + 8);

      if (rand.nextInt(20) == 0 && BiomeDictionary.isBiomeOfType(biome, Type.FOREST)
    		                    && !BiomeDictionary.isBiomeOfType(biome, Type.SNOWY))
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
