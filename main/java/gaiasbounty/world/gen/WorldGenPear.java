package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenPear;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates pear trees during chunk gen. Pear trees can grow in temperate or cold non-coniferous forest biomes.
 *
 * @author Alex Smith
 */
public class WorldGenPear extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenPear();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreePear;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return BiomeDictionary.isBiomeOfType(biome, Type.FOREST)
                && !(BiomeDictionary.isBiomeOfType(biome, Type.HOT) || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)
                || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA) || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE));
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
