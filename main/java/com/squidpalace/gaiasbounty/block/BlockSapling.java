package com.squidpalace.gaiasbounty.block;

import com.squidpalace.gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSapling extends BlockFlower implements IGrowable
{
    public final String[] TREE_TYPES;
    private WorldGenerator[] generators;
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockSapling(String... strings)
    {
        super(strings.length);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3,
                var3 * 2.0F, 0.5F + var3);
        this.TREE_TYPES = strings;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, rand);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0)
            {
                int var6 = world.getBlockMetadata(x, y, z);

                if ((var6 & 8) == 0)
                {
                    world.setBlockMetadataWithNotify(x, y, z, var6 | 8, 3);
                } else
                {
                    this.growTree(world, x, y, z, rand);
                }
            }
        }
    }

    public void setTreeGenerators(WorldGenerator... generators)
    {
        this.generators = generators;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[meta & 3];
    }

    public void growTree(World world, int x, int y, int z, Random rand)
    {
        if (!TerrainGen.saplingGrowTree(world, rand, x, y, z))
        {
            return;
        }

        int meta = world.getBlockMetadata(x, y, z) & 3;
        world.setBlockToAir(x, y, z);

        if (!generators[meta].generate(world, rand, x, y, z))
        {
            world.setBlock(x, y, z, this, meta, 0);
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta & 3;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < TREE_TYPES.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.icons = new IIcon[TREE_TYPES.length];

        for (int i = 0; i < TREE_TYPES.length; ++i)
        {
            this.icons[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                    + "sapling_" + TREE_TYPES[i]);
        }
    }

    /**
     * Returns true if this plant is still growing. If false, it is considered to be fully grown.
     */
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean isClientSide)
    {
        return true;
    }

    /**
     * Returns true if this plant can be fertilized by bonemeal.
     */
    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z)
    {
        return true;
    }

    /**
     * Increments the growth stage of this plant.
     */
    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        if (random.nextFloat() < 0.45D) this.growTree(world, x, y, z, random);
    }
}
