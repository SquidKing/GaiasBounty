package gaiasbounty.world;

import scala.collection.mutable.HashMap;
import java.util.Random;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen._;
import gaiasbounty.world.IWorldGenHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

object WorldGenManager extends IWorldGenerator {
   private val generators = List(new WorldGenApple, new WorldGenPeach, new WorldGenCherry, new WorldGenBanana,
                         new WorldGenOrange, new WorldGenLemon, new WorldGenLime, new WorldGenPlum,
                         new WorldGenMango, new WorldGenPear, new WorldGenPomegranate, new WorldGenFig,
                         new WorldGenWalnut, new WorldGenHazelnut, new WorldGenPecan, new WorldGenAlmond,
                         new WorldGenMacadamia, new WorldGenMesquite, new WorldGenOlive, new WorldGenPalm,
                         new WorldGenSassafras, new WorldGenTea, new WorldGenRubber, new WorldGenMaple);
   private val biomes = new HashMap[Int, List[IWorldGenHandler]];
   
   def init() {
      GameRegistry registerWorldGenerator(this, 5);
   }
   
   def createBiomeAssociations() {
      BiomeGenBase.getBiomeGenArray().foreach(biome => {
         if (biome != null)
            biomes(biome.biomeID) = generators filter(generator => generator isValidSpawnBiome biome)
      });
   }
   
   def generate(random: Random, chunkX: Int, chunkZ: Int, world: World,
            chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider) {
      biomes(world.getBiomeGenForCoords(chunkX * 16 + 8, chunkZ * 16 + 8).biomeID).foreach(generator => {
         if (generator canDoSpawn random)
            generator generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
      });
   }
}
