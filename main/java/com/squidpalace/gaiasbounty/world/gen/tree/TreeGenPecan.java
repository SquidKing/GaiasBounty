package com.squidpalace.gaiasbounty.world.gen.tree;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.world.gen.shape.ShapeGenTreeBig;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenPecan extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        return ShapeGenTreeBig.instance.generate(world, rand, x, y, z,
                BlockManager.logs4, 2, BlockManager.leaves4, 2);
    }
}
