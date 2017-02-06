package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenPlum;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates plum trees during chunk gen. Plum trees can grow in non-dry, temperate or hot non-savannah forest biomes.
 *
 * @author Alex Smith
 */
public class WorldGenPlum extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenPlum();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreePlum;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return BiomeDictionary.isBiomeOfType(biome, Type.FOREST) && !(BiomeDictionary.isBiomeOfType(biome, Type.COLD)
                || BiomeDictionary.isBiomeOfType(biome, Type.DRY) || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)
                || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA) || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE));
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
