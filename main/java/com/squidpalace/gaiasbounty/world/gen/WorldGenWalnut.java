package com.squidpalace.gaiasbounty.world.gen;

import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.world.gen.tree.TreeGenWalnut;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates walnut trees during chunk gen. Walnut trees can grow in river, hills, or mountain biomes.
 *
 * @author Alex Smith
 */
public class WorldGenWalnut extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenWalnut();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeWalnut;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return BiomeDictionary.isBiomeOfType(biome, Type.RIVER) || BiomeDictionary.isBiomeOfType(biome, Type.HILLS)
                && BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN);
    }

    @Override
    public boolean canSpawnRandom(Random random)
    {
        return 0 == random.nextInt(40);
    }

    @Override
    protected WorldGenerator getGenerator()
    {
        return GENERATOR;
    }
}
