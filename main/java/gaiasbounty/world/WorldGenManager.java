package gaiasbounty.world;

import scala.collection.mutable.HashMap;

import java.util.Random;
import java.util.ArrayList;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.*;
import gaiasbounty.world.gen.IWorldGenBase;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenManager implements IWorldGenerator
{
    public static final WorldGenManager INSTANCE = new WorldGenManager();

    private static IWorldGenBase[] generators = {new WorldGenApple(), new WorldGenPeach(), new WorldGenCherry(),
            new WorldGenBanana(), new WorldGenOrange(), new WorldGenLemon(), new WorldGenLime(), new WorldGenPlum(),
            new WorldGenMango(), new WorldGenPear(), new WorldGenPomegranate(), new WorldGenFig(),
            new WorldGenWalnut(), new WorldGenHazelnut(), new WorldGenPecan(), new WorldGenAlmond(),
            new WorldGenMacadamia(), new WorldGenMesquite(), new WorldGenOlive(), new WorldGenPalm(),
            new WorldGenSassafras(), new WorldGenTea(), new WorldGenRubber(), new WorldGenMaple()};
    private static IWorldGenBase[][] biomeGenerators;

    private WorldGenManager() {}

    public static void init()
    {
        GameRegistry.registerWorldGenerator(INSTANCE, 5);
    }

    public static void createBiomeAssociations()
    {
        BiomeGenBase[] biomes = BiomeGenBase.getBiomeGenArray();
        WorldGenManager.biomeGenerators = new IWorldGenBase[biomes.length][];
        for (int i = 0; i < biomes.length; i++)
        {
            if (biomes[i] != null)
            {
                ArrayList<IWorldGenBase> validGenerators = new ArrayList<IWorldGenBase>();
                for (int j = 0; j < generators.length; j++)
                {
                    if (generators[j].isSpawnConfigured() && generators[j].isValidSpawnBiome(biomes[i]))
                        validGenerators.add(generators[j]);
                }
                biomeGenerators[biomes[i].biomeID] = validGenerators.toArray(new IWorldGenBase[validGenerators.size()]);
            }
        }
    }

    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        IWorldGenBase[] biomeGenerators =
                WorldGenManager.biomeGenerators[world.getBiomeGenForCoords(chunkX * 16 + 8, chunkZ * 16 + 8).biomeID];
        for (int i = 0; i < biomeGenerators.length; i++)
        {
            if (biomeGenerators[i].canSpawnRandom(random))
                biomeGenerators[i].generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }
}
