package com.squidpalace.gaiasbounty.world.gen.tree;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.world.gen.shape.ShapeGenTreeJumbo;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenFig extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        return ShapeGenTreeJumbo.instance.generate(world, rand, x, y, z,
                BlockManager.logs3, 3, BlockManager.leaves3, 3);
    }
}
