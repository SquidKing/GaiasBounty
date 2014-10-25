package gaiasbounty.item;

import gaiasbounty.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemToolGeneric extends Item
{
   private String texName;
   
   public ItemToolGeneric(int durability, String texName)
   {
      super();
      this.setMaxStackSize(1);
      this.setMaxDamage(durability);
      this.texName = texName;
   }

   @Override
   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister icons)
   {
      this.itemIcon = icons.registerIcon(Reference.GB_TEX_PREFIX
               + this.texName);
   }
}
