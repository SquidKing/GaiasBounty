package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;

public class ItemSapling4 extends ItemMultiBlock
{
   public ItemSapling4(Block block)
   {
      super(block);
      subNames = BlockManager.tree4Subtypes;
      setUnlocalizedName("saplings4");
   }
   
   @Override
   public IIcon getIconFromDamage(int dmg)
   {
      return BlockManager.saplings4.getIcon(0, dmg);
   }
}
