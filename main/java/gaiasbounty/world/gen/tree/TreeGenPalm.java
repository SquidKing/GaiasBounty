package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;
import gaiasbounty.world.gen.shape.ShapeGenTreePalm;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenPalm extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        return ShapeGenTreePalm.instance.generate(world, rand, x, y, z,
                BlockManager.logs5, 3, BlockManager.leaves5, 3);
    }
}
