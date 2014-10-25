package gaiasbounty.block;

import gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeFruit extends Block implements IFertilizeable
{
   @SideOnly(Side.CLIENT) private IIcon[] iconArray;
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
      int growthStage = (meta & 12) >> 2;
      if (growthStage > 1)
         growthStage--;
      int fruitType = meta & 3;
      return iconArray[((fruitType) * 3) + growthStage];
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
      int growthStage = (world.getBlockMetadata(x, y, z) & 12) >> 2;
      
      if (growthStage < 3)
      {
         int fruitType = world.getBlockMetadata(x, y, z) & 3;
         
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
      int fruitType = world.getBlockMetadata(x, y, z) & 3;
      return this.fruits[fruitType].getItem();
   }
   
   @Override
   public Item getItemDropped(int meta, Random rand, int par3)
   {
      int growthStage = (meta & 12) >> 2;
      int fruitType = meta & 3;
      
      if (growthStage < 3)
      {
         return null;
      }
      else
      {
         return this.fruits[meta & 3].getItem();
      }
   }
   
   @Override
   public int damageDropped(int meta)
   {
      return this.fruits[meta & 3].getItemDamage();
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
      this.iconArray = new IIcon[this.fruitTypes.length * 3];
      
      for (int i = 0; i < fruitTypes.length; ++i)
      {
         for (int j = 0; j < 3; ++j)
         {
            this.iconArray[i * 3 + j] = icons
                     .registerIcon(Reference.GB_TEX_PREFIX + "treefruit_" + fruitTypes[i]
                              + "_" + j);
         }
      }
   }

   @Override
   public boolean fertilize(World world, Random rand, int x, int y, int z)
   {
      if (this.growFruit(world, x, y, z, rand, true))
      {
         world.playAuxSFX(2005, x, y, z, 0);
         return true;
      }
      return false;
   }
}
