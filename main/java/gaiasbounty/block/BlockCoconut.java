package gaiasbounty.block;

import java.util.ArrayList;
import java.util.Random;

import gaiasbounty.item.ItemManager;
import gaiasbounty.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class BlockCoconut extends BlockCocoa implements IFertilizeable
{
   @SideOnly(Side.CLIENT)
   private IIcon[] iconArray;
   
   public BlockCoconut()
   {
      super();
   }
   
   public boolean growCoconut(World world, int x, int y, int z)
   {
      int meta = world.getBlockMetadata(x, y, z);
      int growthStage = func_149987_c(meta);

      if (growthStage < 2)
      {
         world.setBlockMetadataWithNotify(x, y, z, 8 | getDirection(meta), 2);
         return true;
      }
      return false;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int side, int meta)
   {
       return this.iconArray[2];
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public IIcon getCocoaIcon(int par1)
   {
       if (par1 < 0 || par1 >= this.iconArray.length)
       {
           par1 = this.iconArray.length - 1;
       }

       return this.iconArray[par1];
   }
   
   @Override
   public boolean canBlockStay(World world, int x, int y, int z)
   {
       int l = getDirection(world.getBlockMetadata(x, y, z));
       x += Direction.offsetX[l];
       z += Direction.offsetZ[l];
       Block logBlock = world.getBlock(x, y, z);
       return logBlock == BlockManager.logs5 &&
                BlockLog.func_150165_c(world.getBlockMetadata(x, y, z)) == 3;
   }
   
   @Override
   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
   {
       ArrayList<ItemStack> dropped = new ArrayList();
       int growthStage = func_149987_c(meta);
       
       if (growthStage > 1)
           dropped.add(new ItemStack(ItemManager.foodCrop, 1, 17));
       
       return dropped;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public Item getItem(World par1World, int par2, int par3, int par4)
   {
       return ItemManager.foodCrop;
   }
   
   @Override
   public int getDamageValue(World par1World, int par2, int par3, int par4)
   {
       return 17;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister icons)
   {
       this.iconArray = new IIcon[3];

       for (int i = 0; i < 3; i++)
          this.iconArray[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                   + "coconut_" + i);
   }

   @Override
   public Item getItemDropped(int par1, Random par2Random, int par3)
   {
       return null;
   }

   @Override
   public boolean fertilize(World world, Random rand, int x, int y, int z)
   {
      if (this.growCoconut(world, x, y, z))
      {
         world.playAuxSFX(2005, x, y, z, 0);
         return true;
      }
      return false;
   }
}
