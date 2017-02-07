package com.squidpalace.gaiasbounty.world.gen;

import com.squidpalace.gaiasbounty.config.ConfigManager;
import com.squidpalace.gaiasbounty.world.gen.tree.TreeGenBanana;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates banana trees during chunk gen. Banana trees can grow in hot, humid jungle biomes.
 *
 * @author Alex Smith
 */
public class WorldGenBanana extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenBanana();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeBanana;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) && BiomeDictionary.isBiomeOfType(biome, Type.HOT)
                && BiomeDictionary.isBiomeOfType(biome, Type.WET);
    }

    @Override
    public boolean canSpawnRandom(Random random)
    {
        return 0 == random.nextInt(20);
    }

    @Override
    protected WorldGenerator getGenerator()
    {
        return GENERATOR;
    }
}
