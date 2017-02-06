package gaiasbounty.block;

import gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlowerMulti extends BlockFlower implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockFlowerMulti(int id)
    {
        super(id);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < 16; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.icons = new IIcon[16];

        for (int i = 0; i < 16; i++)
        {
            this.icons[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                    + "flower_" + i);
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
        if (0 == random.nextInt(3))
        {
            ItemStack flowerDrop = new ItemStack(BlockManager.flower, 1,
                    world.getBlockMetadata(x, y, z));
            EntityItem worldDrop = new EntityItem(world, x + 0.5F,
                    y + 1.25F, z + 0.5F, flowerDrop);
            world.spawnEntityInWorld(worldDrop);
        }
    }
}
