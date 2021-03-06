package com.squidpalace.gaiasbounty.world.gen;

import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.world.gen.tree.TreeGenPomegranate;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates pomegranate trees during chunk gen. Pomegranate trees can grow in temperate or hot hill or mountain biomes.
 *
 * @author Alex Smith
 */
public class WorldGenPomegranate extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenPomegranate();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreePomegranate;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return (BiomeDictionary.isBiomeOfType(biome, Type.HILLS) || BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN))
                && !BiomeDictionary.isBiomeOfType(biome, Type.COLD);
    }

    @Override
    public boolean canSpawnRandom(Random random)
    {
        return 0 == random.nextInt(35);
    }

    @Override
    protected WorldGenerator getGenerator()
    {
        return GENERATOR;
    }
}
