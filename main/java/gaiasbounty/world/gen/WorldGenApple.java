package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenApple;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates apple trees during chunk gen. Apple trees can grow in temperate or cold non-coniferous forest biomes.
 *
 * @author Alex Smith
 */
public class WorldGenApple extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenApple();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeApple;
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
        return 0 == random.nextInt(30);
    }

    @Override
    protected WorldGenerator getGenerator()
    {
        return GENERATOR;
    }
}
