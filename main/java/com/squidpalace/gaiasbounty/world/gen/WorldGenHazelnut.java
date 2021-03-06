package com.squidpalace.gaiasbounty.world.gen;

import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.world.gen.tree.TreeGenHazelnut;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates hazelnut trees during chunk gen. Hazelnut trees can grow in non-hot, non-wet forest biomes.
 *
 * @author Alex Smith
 */
public class WorldGenHazelnut extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenHazelnut();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeHazelnut;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && !(BiomeDictionary.isBiomeOfType(biome, Type.HOT)
                || BiomeDictionary.isBiomeOfType(biome, Type.WET));
    }

    @Override
    public boolean canSpawnRandom(Random random)
    {
        return 0 == random.nextInt(30);
    }

    @Override
    protected WorldGenerator getGenerator()
    {
        return GENERATOR;
    }
}
