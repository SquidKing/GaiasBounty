package com.squidpalace.gaiasbounty.block;

import com.squidpalace.gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLeavesStandard extends BlockLeaves
{
    public String[] leaf_types;
    protected ItemStack[] rareLeafDrops;
    protected int[] rareDropRates;
    private int[] saplingDropRates = {20, 20, 20, 20};
    private Item saplingItem;
    int[] adjacentTreeBlocks;
    @SideOnly(Side.CLIENT)
    private int gfxIconOffset;
    private IIcon[][] icons;

    public BlockLeavesStandard(String... leaves)
    {
        super();
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setStepSound(soundTypeGrass);
        this.leaf_types = leaves;
        this.setRareLeafDrops(null, 1, null, 1, null, 1, null, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0xffffff;
    }

    @Override
    public int getRenderColor(int par1)
    {
        return 0xffffff;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2,
                               int par3, int z)
    {
        return 0xffffff;
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

                                if (!world.isAirBlock(x + var12, y + var13, z + var14)
                                        && block.canSustainLeaves(world, x + var12, y
                                        + var13, z + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10
                                            + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (!world.isAirBlock(x + var12, y + var13, z + var14)
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
        }
    }

    protected void removeLeaves(World world, int x, int y, int z)
    {
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return this.saplingItem;
    }

    public void setSaplingItem(Item item)
    {
        this.saplingItem = item;
    }

    public void setSaplingItem(Block block)
    {
        this.setSaplingItem(Item.getItemFromBlock(block));
    }

    public void setSaplingDropRates(int rate1, int rate2, int rate3, int rate4)
    {
        this.saplingDropRates[0] = rate1;
        this.saplingDropRates[1] = rate2;
        this.saplingDropRates[2] = rate3;
        this.saplingDropRates[3] = rate4;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z,
                                          int meta, float par6, int par7)
    {
        if (!world.isRemote)
        {
            if (world.rand.nextInt(this.saplingDropRates[meta & 3]) == 0)
            {
                Item dropItem = this.getItemDropped(meta, world.rand, par7);
                this.dropBlockAsItem(world, x, y, z, new ItemStack(dropItem, 1,
                        this.damageDropped(meta)));
            }

            if (this.rareLeafDrops[meta & 3] != null
                    && world.rand.nextInt(this.rareDropRates[meta & 3]) == 0)
                this.dropBlockAsItem(world, x, y, z,
                        ItemStack.copyItemStack(this.rareLeafDrops[meta & 3]));
        }
    }

    public void setRareLeafDrops(ItemStack stack1, int rate1, ItemStack stack2,
                                 int rate2, ItemStack stack3, int rate3, ItemStack stack4, int rate4)
    {
        this.rareLeafDrops = new ItemStack[4];
        this.rareLeafDrops[0] = stack1;
        this.rareLeafDrops[1] = stack2;
        this.rareLeafDrops[2] = stack3;
        this.rareLeafDrops[3] = stack4;

        this.rareDropRates = new int[4];
        this.rareDropRates[0] = rate1;
        this.rareDropRates[1] = rate2;
        this.rareDropRates[2] = rate3;
        this.rareDropRates[3] = rate4;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[meta & 3][this.field_150121_P ? 0 : 1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setGraphicsLevel(boolean gfxLevel)
    {
        this.field_150121_P = gfxLevel;
        this.gfxIconOffset = gfxLevel ? 0 : 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < leaf_types.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int x,
                                        int y, int z, int side)
    {
        Block block = par1IBlockAccess.getBlock(x, y, z);
        return !this.field_150121_P && block == this ? false : super
                .shouldSideBeRendered(par1IBlockAccess, x, y, z, side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.icons = new IIcon[leaf_types.length][2];

        for (int i = 0; i < 4; ++i)
        {
            this.icons[i][0] = icons.registerIcon(Reference.GB_TEX_PREFIX
                    + "leaves_" + leaf_types[i]);
            this.icons[i][1] = icons.registerIcon(Reference.GB_TEX_PREFIX
                    + "leaves_" + leaf_types[i] + "_opaque");
        }
    }

    @Override
    public String[] func_150125_e()
    {
        return leaf_types;
    }
}
