package gaiasbounty.item;

import gaiasbounty.lib.Reference;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMaterialMulti extends Item
{
   protected String[] materialNames;
   @SideOnly(Side.CLIENT) protected IIcon[] iconArray;
   
   public ItemMaterialMulti(String... materialNames)
   {
      super();
      this.materialNames = materialNames;
      this.hasSubtypes = true;
   }
   
   public ItemMaterialMulti(String materialName)
   {
      this(getSingleStringArray(materialName));
   }
   
   private static String[] getSingleStringArray(String s)
   {
      String[] a = {s};
      return a;
   }
   
   @Override
   public String getUnlocalizedName(ItemStack itemStack)
   {
      return getUnlocalizedName() + "."
               + materialNames[itemStack.getItemDamage()];
   }
   
   @Override
   public IIcon getIconFromDamage(int dmg)
   {
      int index = MathHelper.clamp_int(dmg, 0, materialNames.length);
      return this.iconArray[index];
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void getSubItems(Item item, CreativeTabs tab, List itemList)
   {
      int numMats = this.materialNames.length;
      
      for (int i = 0; i < numMats; i++)
      {
         itemList.add(new ItemStack(item, 1, i));
      }
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister icons)
   {
      this.iconArray = new IIcon[materialNames.length];
      
      for (int i = 0; i < materialNames.length; ++i)
      {
         this.iconArray[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                  + materialNames[i]);
      }
   }
}
