package com.squidpalace.gaiasbounty.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockLeavesFruit extends BlockLeavesStandard implements IGrowable
{
    protected Block fruitBlock;

    public BlockLeavesFruit(String... leaves)
    {
        super(leaves);
        this.rareLeafDrops = new ItemStack[4];
        for (int i = 0; i < 4; i++)
            this.rareLeafDrops[i] = null;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        boolean canGrow = true;

        if (!world.isRemote)
        {
            int meta = world.getBlockMetadata(x, y, z);

            if ((meta & 8) != 0 && (meta & 4) == 0)
            {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;

                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[var9 * var9 * var9];
                }

                int var12;

                if (world.checkChunksExist(x - var8, y - var8, z - var8, x + var8,
                        y + var8, z + var8))
                {
                    int var13;
                    int var14;

                    for (var12 = -var7; var12 <= var7; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                Block block = world.getBlock(x + var12, y + var13, z
                                        + var14);

                                if (block != Block.getBlockFromName("air")
                                        && block.canSustainLeaves(world, x + var12, y
                                        + var13, z + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10
                                            + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (block != Block.getBlockFromName("air")
                                        && block.isLeaves(world, x + var12, y + var13,
                                        z + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10
                                            + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10
                                            + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }
                    }

                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                for (int var15 = -var7; var15 <= var7; ++var15)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + var11) * var10
                                            + (var14 + var11) * var9 + var15 + var11] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + var11 - 1)
                                                * var10 + (var14 + var11) * var9 + var15
                                                + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 - 1)
                                                    * var10 + (var14 + var11) * var9
                                                    + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11 + 1)
                                                * var10 + (var14 + var11) * var9 + var15
                                                + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 + 1)
                                                    * var10 + (var14 + var11) * var9
                                                    + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11)
                                                * var10 + (var14 + var11 - 1) * var9
                                                + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11)
                                                    * var10 + (var14 + var11 - 1) * var9
                                                    + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11)
                                                * var10 + (var14 + var11 + 1) * var9
                                                + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11)
                                                    * var10 + (var14 + var11 + 1) * var9
                                                    + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11)
                                                * var10 + (var14 + var11) * var9
                                                + (var15 + var11 - 1)] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11)
                                                    * var10 + (var14 + var11) * var9
                                                    + (var15 + var11 - 1)] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11)
                                                * var10 + (var14 + var11) * var9 + var15
                                                + var11 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11)
                                                    * var10 + (var14 + var11) * var9
                                                    + var15 + var11 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9
                        + var11];

                if (var12 >= 0)
                {
                    world.setBlock(x, y, z, this, meta & -9, 0);
                } else
                {
                    this.removeLeaves(world, x, y, z);
                    canGrow = false;
                }
            }

            if (canGrow && rand.nextInt(this.growRate(world.getBlockMetadata(x, y, z))) == 0)
                this.growFruit(world, x, y, z);
        }
    }

    public boolean growFruit(World world, int x, int y, int z)
    {
        if (world.blockExists(x, y - 1, z)
                && world.isAirBlock(x, y - 1, z))
        {
            world.setBlock(x, y - 1, z, this.fruitBlock,
                    world.getBlockMetadata(x, y, z) & 3, 3);
            return true;
        } else return false;
    }

    protected int growRate(int meta)
    {
        return 70;
    }

    public void setFruitBlock(Block fruitBlock)
    {
        this.fruitBlock = fruitBlock;
    }

    /**
     * Returns true if this plant is still growing. If false, it is considered to be fully grown.
     */
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean isClientSide)
    {
        return world.blockExists(x, y - 1, z) && world.isAirBlock(x, y - 1, z);
    }

    /**
     * Returns true if this plant can be fertilized by bonemeal.
     */
    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z)
    {
        return world.blockExists(x, y - 1, z) && world.isAirBlock(x, y - 1, z);
    }

    /**
     * Increments the growth stage of this plant.
     */
    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        this.growFruit(world, x, y, z);
    }
}
