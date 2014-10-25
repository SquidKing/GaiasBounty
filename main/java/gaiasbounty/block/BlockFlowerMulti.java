package gaiasbounty.block;

import java.util.List;
import java.util.Random;

import gaiasbounty.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFlowerMulti extends BlockFlower implements IFertilizeable
{
   @SideOnly(Side.CLIENT) private IIcon[] iconArray;

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
      return this.iconArray[meta];
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
      this.iconArray = new IIcon[16];
      
      for (int i = 0; i < 16; i++)
      {
         this.iconArray[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                  + "flower_" + i);
      }
   }

   @Override
   public boolean fertilize(World world, Random rand, int x, int y, int z)
   {
      world.playAuxSFX(2005, x, y, z, 0);
      
      if (rand.nextInt(3) == 0)
      {
         ItemStack flowerDrop = new ItemStack(BlockManager.flower, 1,
                  world.getBlockMetadata(x, y, z));
         EntityItem worldDrop = new EntityItem(world, x + 0.5F,
                  y + 1.25F, z + 0.5F, flowerDrop);
         world.spawnEntityInWorld(worldDrop);
      }
      
      return true;
   }
}
