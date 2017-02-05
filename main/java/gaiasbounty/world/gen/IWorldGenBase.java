package gaiasbounty.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * Base container interface for all Gaia's Bounty world generation features. 
 * 
 * @author Alex Smith
 */
public interface IWorldGenBase {
   /**
    * Checks if this worldgen feature is set to be spawnable in the config file.
    * @return True if this feature is allowed to spawn
    */
   public boolean isSpawnConfigured();
   
   /**
    * Checks if this worldgen feature is able to spawn in a given biome.
    * @param biome Biome to check
    * @return True if this feature can spawn in the given biome
    */
   public boolean isValidSpawnBiome(BiomeGenBase biome);
   
   /**
    * Randomly returns true or false.
    * @param random Random generator
    * @return True or false (random)
    */
   public boolean canSpawnRandom(Random random);
   
   /**
    * Attempt to generate in the world.
    * @param random Random generator
    * @param chunkX X coordinate of the chunk in the world
    * @param chunkZ Z coordinate of the chunk in the world
    * @param world The world to generate in
    * @param chunkGenerator
    * @param chunkProvider
    */
   public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider);
}
