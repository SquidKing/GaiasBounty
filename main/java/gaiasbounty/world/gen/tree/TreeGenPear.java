package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;
import gaiasbounty.world.gen.shape.ShapeGenTreeTall;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenPear extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        return ShapeGenTreeTall.instance.generate(world, rand, x, y, z,
                BlockManager.logs3, 1, BlockManager.leaves3, 1);
    }
}
