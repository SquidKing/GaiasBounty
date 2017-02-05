package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;

public class ItemSapling3 extends ItemMultiBlock
{
   public ItemSapling3(Block block)
   {
      super(block);
      subNames = BlockManager.tree3Subtypes;
      setUnlocalizedName("saplings3");
   }
   
   @Override
   public IIcon getIconFromDamage(int dmg)
   {
      return BlockManager.saplings3.getIcon(0, dmg);
   }
}
