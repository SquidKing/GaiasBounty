package gaiasbounty.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * 
 * @author Alex Smith
 */
public interface IWorldGenHandler {
   public boolean isValidSpawnBiome(BiomeGenBase biome);
   public boolean canDoSpawn(Random random);
   public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider);
}
