package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSapling5 extends ItemMultiBlock
{
   public ItemSapling5(Block block)
   {
      super(block);
      subNames = BlockManager.tree5Subtypes;
      setUnlocalizedName("saplings5");
   }
   
   @Override
   public IIcon getIconFromDamage(int dmg)
   {
      return BlockManager.saplings5.getIcon(0, dmg);
   }
}
