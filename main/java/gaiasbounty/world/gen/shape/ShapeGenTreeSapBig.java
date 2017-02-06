package gaiasbounty.world.gen.shape;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ShapeGenTreeSapBig extends ShapeGenTree
{
    public static final ShapeGenTree instance = new ShapeGenTreeSapBig();

    private Block sapBlock;
    private int[] sapMeta;

    public ShapeGenTree setSapBlock(Block sapBlock, int... sapMeta)
    {
        this.sapBlock = sapBlock;
        this.sapMeta = sapMeta;
        return this;
    }

    protected int height(Random rand)
    {
        return rand.nextInt(2) + 8;
    }

    protected boolean check(World world, int x, int y, int z, int height)
    {
        int checkX;
        int checkY;
        int checkZ;
        Block checkBlock;

        if (y < 1 || y + height + 1 > 256) return false;
        checkBlock = world.getBlock(x, y - 1, z);
        if ((checkBlock != Blocks.grass && checkBlock != Blocks.dirt)
                || y > 254 - height)
            return false;

        for (checkY = y; checkY <= y + 1 + height; ++checkY)
        {
            byte checkPlanarDist = 1;

            if (checkY == y)
            {
                checkPlanarDist = 0;
            }

            if (checkY >= y + 1 + height - 4)
            {
                checkPlanarDist = 3;
            }

            for (checkX = x - checkPlanarDist; checkX <= x + checkPlanarDist; ++checkX)
            {
                for (checkZ = z - checkPlanarDist; checkZ <= z + checkPlanarDist; ++checkZ)
                {
                    if (checkY >= 0 && checkY < 256)
                    {
                        checkBlock = world.getBlock(checkX, checkY, checkZ);

                        if (!world.isAirBlock(checkX, checkY, checkZ)
                                && !checkBlock.isLeaves(world, checkX, checkY, checkZ))
                            return false;
                    } else return false;
                }
            }
        }

        return true;
    }

    protected void makeTree(World world, Random rand, int x, int y,
                            int z, int height, Block logBlock, int logMeta, Block leafBlock, int leafMeta)
    {
        world.setBlock(x, y - 1, z, Blocks.dirt);
        int genY, genX, genZ, leafLayer, leafSpread;
        Block genPosBlock;
        int numLeafLayers = rand.nextInt(2) + 5;

        for (genY = y - numLeafLayers + height; genY <= y + height; genY++)
        {
            leafLayer = genY - (y + height);
            leafSpread = leafLayer == -numLeafLayers ? 2
                    : (leafLayer < -2 ? 3 : 1 - (leafLayer - 1) / 2);

            for (genX = x - leafSpread; genX <= x + leafSpread; genX++)
            {
                int placeX = genX - x;

                for (genZ = z - leafSpread; genZ <= z + leafSpread; genZ++)
                {
                    int placeZ = genZ - z;
                    Block block = world.getBlock(genX, genY, genZ);

                    if ((Math.abs(placeX) != leafSpread
                            || Math.abs(placeZ) != leafSpread || rand.nextInt(2) != 0
                            && (leafLayer == -2 || leafLayer == -numLeafLayers))
                            && (Math.abs(placeX) + Math.abs(placeZ) < 5)
                            && (world.isAirBlock(genX, genY, genZ) || block
                            .canBeReplacedByLeaves(world, genX,
                                    genY, genZ)))
                    {
                        world.setBlock(genX, genY, genZ, leafBlock, leafMeta, 2);
                    }
                }
            }
        }

        for (genY = 0; genY < height; ++genY)
        {
            genPosBlock = world.getBlock(x, y + genY, z);

            if (world.isAirBlock(x, y + genY, z)
                    || genPosBlock.isLeaves(world, x, y + genY, z))
            {
                if (genY == 1)
                    world.setBlock(x, y + genY, z, this.sapBlock,
                            this.sapMeta[rand.nextInt(this.sapMeta.length)], 2);
                else
                    world.setBlock(x, y + genY, z, logBlock, logMeta, 2);
            }
        }
    }
}
