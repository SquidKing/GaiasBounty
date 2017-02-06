package gaiasbounty.world.gen;

import gaiasbounty.config.ConfigManager;
import gaiasbounty.world.gen.tree.TreeGenMesquite;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Creates mesquite trees during chunk gen. Mesquite trees can grow in savannah, mesa, or plains biomes.
 *
 * @author Alex Smith
 */
public class WorldGenMesquite extends WorldGenTreeBase
{
    private static final WorldGenerator GENERATOR = new TreeGenMesquite();

    @Override
    public boolean isSpawnConfigured()
    {
        return ConfigManager.canGenTreeMesquite;
    }

    @Override
    public boolean isValidSpawnBiome(BiomeGenBase biome)
    {
        return !(BiomeDictionary.isBiomeOfType(biome, Type.COLD) || BiomeDictionary.isBiomeOfType(biome, Type.WET))
                && (BiomeDictionary.isBiomeOfType(biome, Type.DRY) || BiomeDictionary.isBiomeOfType(biome, Type.HOT)
                || BiomeDictionary.isBiomeOfType(biome, Type.SPARSE)) && (BiomeDictionary.isBiomeOfType(biome, Type.PLAINS)
                || BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA) || BiomeDictionary.isBiomeOfType(biome, Type.MESA));
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
