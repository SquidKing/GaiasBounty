package gaiasbounty.block;

import static net.minecraftforge.common.EnumPlantType.Crop;

import gaiasbounty.item.ItemManager;
import gaiasbounty.lib.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCropsBase extends BlockBush implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    private boolean use8Icons;
    private String cropType;
    private ItemStack produce;
    private ItemStack seeds;
    private float baseGrowthChanceModifier;

    public BlockCropsBase(String cropType, boolean use8Icons, float baseGrowthChanceModifier)
    {
        super(Material.plants);
        this.setStepSound(soundTypeGrass);
        this.cropType = cropType;
        this.use8Icons = use8Icons;
        this.baseGrowthChanceModifier = baseGrowthChanceModifier;
    }

    public BlockCropsBase(String cropType, boolean use8Icons)
    {
        this(cropType, use8Icons, 25.0f);
    }

    public BlockCropsBase(String cropType)
    {
        this(cropType, false, 25.0f);
    }

    public void setSeedAndProduce(ItemStack seeds, ItemStack produce)
    {
        this.setSeedItem(seeds);
        this.setProduceItem(produce);
    }

    public void setProduceItem(ItemStack produce)
    {
        this.produce = produce;
    }

    public void setSeedItem(ItemStack seeds)
    {
        this.seeds = seeds;
    }

    /**
     * Returns the produce item for the given crop type.
     *
     * @param cropType
     * @return Produce item
     */
    public ItemStack getProduceItem()
    {
        return this.produce.copy();
    }

    /**
     * Returns the seed item for the given crop type.
     *
     * @param cropType
     * @return Seed item
     */
    public ItemStack getSeedItem()
    {
        return this.seeds.copy();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icons[meta];
    }

    @Override
    public int getRenderType()
    {
        return 6;
    }

    @Override
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.farmland;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        super.updateTick(world, x, y, z, random);

        if (world.getBlockLightValue(x, y + 1, z) > 8)
        {
            int meta = world.getBlockMetadata(x, y, z);

            if (meta < 7)
            {
                if (0 == random.nextInt((int) (this.baseGrowthChanceModifier / this.getGrowthChance(world, x, y, z))))
                    world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
            }
        }
    }

    private float getGrowthChance(World world, int x, int y, int z)
    {
        float chance = 1.0f;
        boolean sameNorthSouth = this == world.getBlock(x, y, z - 1) || this == world.getBlock(x, y, z + 1);
        boolean sameEastWest = this == world.getBlock(x - 1, y, z) || this == world.getBlock(x + 1, y, z);
        boolean sameDiagonal = this == world.getBlock(x - 1, y, z - 1) || this == world.getBlock(x + 1, y, z - 1)
                || this == world.getBlock(x - 1, y, z + 1) || this == world.getBlock(x + 1, y, z + 1);

        for (int scanX = x - 1; scanX < x + 1; ++scanX)
        {
            for (int scanZ = z - 1; scanZ < z + 1; ++scanZ)
            {
                float scanChance = 0.0f;
                Block scanBlock = world.getBlock(scanX, y - 1, scanZ);

                if (scanBlock.canSustainPlant(world, scanX, y - 1, scanZ, ForgeDirection.UP, this))
                    scanChance = scanBlock.isFertile(world, scanX, y - 1, scanZ) ? 3.0f : 1.0f;
                if (scanX == x || scanZ == z)
                    scanChance /= 4.0f;

                chance += scanChance;
            }
        }

        if (sameDiagonal || sameNorthSouth && sameEastWest)
            chance /= 2.0f;

        return chance;
    }
   
   /*@Override
   @SideOnly(Side.CLIENT)
   public void getSubBlocks(Item item, CreativeTabs tabs, List blockList) {}*/

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.icons = new IIcon[8];

        for (int i = 0; i < 8; ++i)
        {
            int n = i;

            if (!this.use8Icons)
            {
                switch (n)
                {
                    case 0:
                    case 1:
                        n = 0;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        n = 1;
                        break;
                    case 5:
                    case 6:
                        n = 2;
                        break;
                    case 7:
                    default:
                        n = 3;
                }
            }

            this.icons[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                    + "crop_" + this.cropType + "_" + n);
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if (meta >= 7)
        {
            ret.add(this.getProduceItem());
            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (world.rand.nextInt(15) <= meta) ret.add(this.getSeedItem());
            }
        } else ret.add(this.getSeedItem());

        return ret;
    }

    /**
     * Returns true if this plant is still growing. If false, it is considered to be fully grown.
     */
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean isClientSide)
    {
        return 7 != world.getBlockMetadata(x, y, z);
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
        int meta = world.getBlockMetadata(x, y, z) + random.nextInt(4) + 2;
        world.setBlockMetadataWithNotify(x, y, z, meta > 7 ? 7 : meta, 2);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return Crop;
    }
}
