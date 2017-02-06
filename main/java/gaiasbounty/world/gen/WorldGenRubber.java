package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenRubber;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates rubber trees during chunk gen. Rubber trees can grow in temperate or hot non-dry forest, jungle or swamp biomes.
 *
 * @author Alex Smith
 */
public class WorldGenRubber extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenRubber();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeRubber;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return !(BiomeDictionary.isBiomeOfType(biome, Type.COLD) || BiomeDictionary.isBiomeOfType(biome, Type.DRY))
                && (BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)
                || BiomeDictionary.isBiomeOfType(biome, Type.SWAMP));
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
