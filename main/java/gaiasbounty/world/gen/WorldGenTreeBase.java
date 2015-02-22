package gaiasbounty.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import gaiasbounty.world.IWorldGenHandler;

public abstract class WorldGenTreeBase implements IWorldGenHandler
{
   @Override
   public abstract boolean isValidSpawnBiome(BiomeGenBase biome);
   
   @Override
   public abstract boolean canDoSpawn(Random random);
   
   protected abstract WorldGenerator getGenerator();
   
   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      int x, y, z;
      WorldGenerator generator = this.getGenerator();
      
      for (int i = 0; i < 20; i++)
      {
         x = chunkX * 16 + random.nextInt(16);
         z = chunkZ * 16 + random.nextInt(16);
         y = world.getTopSolidOrLiquidBlock(x, z) - 1;

         if (generator.generate(world, random, x, y + 1, z)) break;
      }
   }
}
