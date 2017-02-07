package com.squidpalace.gaiasbounty.world.gen;

import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.world.gen.tree.TreeGenOrange;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates orange trees during chunk gen. Orange trees can grow in humid and hot or temperate forests, jungles, or swamps.
 *
 * @author Alex Smith
 */
public class WorldGenOrange extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenOrange();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeOrange;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return (BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)
                || BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) && BiomeDictionary.isBiomeOfType(biome, Type.WET)
                && !BiomeDictionary.isBiomeOfType(biome, Type.COLD);
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
