package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenSassafras;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates sassafras trees during chunk gen. Sassafras trees can grow in temperate or cold, normal humidity non-hilly forest or plains biomes.
 *
 * @author Alex Smith
 */
public class WorldGenSassafras extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenSassafras();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeSassafras;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return (BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
                && !(BiomeDictionary.isBiomeOfType(biome, Type.HOT) || BiomeDictionary.isBiomeOfType(biome, Type.WET)
                || BiomeDictionary.isBiomeOfType(biome, Type.DRY) || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA)
                || BiomeDictionary.isBiomeOfType(biome, Type.HILLS) || BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN)
                || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS));
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
