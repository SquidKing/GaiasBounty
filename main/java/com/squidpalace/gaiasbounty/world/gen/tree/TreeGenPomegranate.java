package com.squidpalace.gaiasbounty.world.gen.tree;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.world.gen.shape.ShapeGenTreeVanShort;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenPomegranate extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        return ShapeGenTreeVanShort.instance.generate(world, rand, x, y, z,
                BlockManager.logs3, 2, BlockManager.leaves3, 2);
    }
}
