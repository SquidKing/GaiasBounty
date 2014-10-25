package gaiasbounty.block;

import gaiasbounty.lib.Reference;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLogStandard extends BlockLog
{
   public String[] woodType;
   private IIcon[][] iconArray;
   
   public BlockLogStandard(String ... trees)
   {
      super();
      this.setHardness(2.0F);
      this.setStepSound(soundTypeWood);
      this.woodType = trees;
   }
   
   @Override
   public Item getItemDropped(int par1, Random par2Random, int par3)
   {
      return Item.getItemFromBlock(this);
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int side, int meta)
   {
      int facing = meta & 12;
      boolean inner = false;
      inner = (facing == 0 && (side == 1 || side == 0))
               || (facing == 4 && (side == 5 || side == 4))
               || (facing == 8 && (side == 2 || side == 3));
      return this.iconArray[inner ? 1 : 0][meta & 3];
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void getSubBlocks(Item item, CreativeTabs tabs, List list)
   {
      for (int i = 0; i < woodType.length; i++)
         list.add(new ItemStack(item, 1, i));
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister icons)
   {
      iconArray = new IIcon[2][woodType.length];
      for (int i = 0; i < woodType.length; ++i)
      {
         this.iconArray[0][i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                  + "tree_" + woodType[i]);
         this.iconArray[1][i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                  + "tree_" + woodType[i] + "_top");
      }
   }
}
