package gaiasbounty.world.gen.shape;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class ShapeGenTree
{
    protected ShapeGenTree() {}

    public boolean generate(World world, Random rand, int x, int y, int z,
                            Block logBlock, int logMeta, Block leafBlock, int leafMeta)
    {
        int height = height(rand);

        if (check(world, x, y, z, height))
        {
            makeTree(world, rand, x, y, z, height, logBlock, logMeta, leafBlock,
                    leafMeta);
            return true;
        } else
            return false;
    }

    protected abstract int height(Random rand);

    protected abstract boolean check(World world, int x, int y, int z, int height);

    protected abstract void makeTree(World world, Random rand, int x, int y,
                                     int z, int height, Block logBlock, int logMeta, Block leafBlock, int leafMeta);
}
