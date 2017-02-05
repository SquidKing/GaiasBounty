package gaiasbounty.block;

import gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeFruit extends Block implements IGrowable
{
   @SideOnly(Side.CLIENT) private IIcon[][] icons;
   private String[] fruitTypes;
   private ItemStack[] fruits;
   
   public BlockTreeFruit(String ... fruits)
   {
      super(Material.plants);
      this.setTickRandomly(true);
      this.setHardness(0.0F);
      this.setStepSound(soundTypeGrass);
      this.setBlockBounds(0.3F, 0.4F, 0.3F, 0.7F, 1.0F, 0.7F);
      this.fruitTypes = fruits;
   }
   
   public int getGrowthStage(IBlockAccess access, int x, int y, int z)
   {
      return this.getGrowthStage(access.getBlockMetadata(x, y, z));
   }
   
   public int getGrowthStage(int meta)
   {
      return (meta & 12) >> 2;
   }
   
   public int getFruitType(IBlockAccess access, int x, int y, int z)
   {
      return this.getFruitType(access.getBlockMetadata(x, y, z));
   }
   
   public int getFruitType(int meta)
   {
      return meta & 3;
   }
   
   @Override
   public boolean canBlockStay(World world, int x, int y, int z)
   {
      if (!world.isAirBlock(x, y + 1, z))
         return world.getBlock(x, y + 1, z).isLeaves(world, x, y + z, z);
      else return false;
   }
   
   @Override
   public IIcon getIcon(int side, int meta)
   {
      int growthStage = this.getGrowthStage(meta);
      return icons[this.getFruitType(meta)][growthStage > 1 ? growthStage - 1 : growthStage];
   }
   
   @Override
   public int getRenderType()
   {
      return 1;
   }
   
   @Override
   public boolean renderAsNormalBlock()
   {
      return false;
   }
   
   @Override
   public boolean isOpaqueCube()
   {
      return false;
   }
   
   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
            int par2, int par3, int par4)
   {
      return null;
   }
   
   @Override
   public void updateTick(World world, int x, int y, int z, Random rand)
   {
      this.growFruit(world, x, y, z, rand, false);
   }
   
   @Override
   public void onNeighborBlockChange(World world, int x, int y, int z,
            Block neighbour)
   {
      if (!this.canBlockStay(world, x, y, z))
      {
         this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z),
                  0);
         world.setBlockToAir(x, y, z);
      }
   }
   
   /** Attempts to grow the fruit.
    * @param world
    * @param x
    * @param y
    * @param z
    * @param rand
    * @param full Whether or not the fruit should be fully grown (ie. bonemeal used)
    * @return True if growth succeeded
    */
   public boolean growFruit(World world, int x, int y, int z, Random rand, boolean full)
   {
      int growthStage = this.getGrowthStage(world, x, y, z);
      
      if (growthStage < 3)
      {
         int fruitType = this.getFruitType(world, x, y, z);
         
         if (full)
         {
            world.setBlockMetadataWithNotify(x, y, z, 12 + fruitType, 3);
            return true;
         }
         else if (rand.nextInt(25) == 0)
         {
            world.setBlockMetadataWithNotify(x, y, z, ((growthStage + 1) << 2)
                     + fruitType, 3);
            return true;
         }
         else return false;
      }
      else if (growthStage == 3 && !full)
      {
         if (rand.nextInt(60) == 0)
         {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z),
                     0);
            world.setBlockToAir(x, y, z);
            return true;
         }
         else return false;
      }
      else return false;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public Item getItem(World world, int x, int y, int z)
   {
      return this.fruits[this.getFruitType(world, x, y, z)].getItem();
   }
   
   @Override
   public Item getItemDropped(int meta, Random random, int fortune)
   {
      return this.getGrowthStage(meta) < 3 ? null : this.fruits[this.getFruitType(meta)].getItem();
   }
   
   @Override
   public int damageDropped(int meta)
   {
      return this.fruits[this.getFruitType(meta)].getItemDamage();
   }
   
   public void setFruitItems(ItemStack ... newFruits)
   {
      this.fruits = newFruits;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void getSubBlocks(Item item, CreativeTabs tabs, List blockList) {}
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister icons)
   {
      this.icons = new IIcon[this.fruitTypes.length][3];
      
      for (int i = 0; i < fruitTypes.length; ++i)
      {
         for (int j = 0; j < 3; ++j)
         {
            this.icons[i][j] = icons
                     .registerIcon(Reference.GB_TEX_PREFIX + "treefruit_" + fruitTypes[i]
                              + "_" + j);
         }
      }
   }

   /**
    * Returns true if this plant is still growing. If false, it is considered to be fully grown.
    */
   @Override
   public boolean func_149851_a(World world, int x, int y, int z, boolean isClientSide)
   {
      return this.getGrowthStage(world, x, y, z) < 3;
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
      this.growFruit(world, x, y, z, random, true);
   }
}
