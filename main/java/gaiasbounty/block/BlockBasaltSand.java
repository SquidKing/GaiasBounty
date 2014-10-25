package gaiasbounty.block;

import gaiasbounty.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBasaltSand extends BlockFalling
{
   private IIcon icon;
   
   public BlockBasaltSand()
   {
      super();
      this.setHardness(0.5F);
      this.setStepSound(soundTypeSand);
   }
   
   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int side, int meta)
   {
       return this.icon;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister icons)
   {
       icon = icons.registerIcon(Reference.GB_TEX_PREFIX + "basalt_sand");
   }
}
