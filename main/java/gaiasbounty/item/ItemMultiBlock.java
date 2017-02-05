package gaiasbounty.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMultiBlock extends ItemBlock
{
   protected String[] subNames;
   
   public ItemMultiBlock(Block block)
   {
      super(block);
      setHasSubtypes(true);
   }
   
   @Override
   public int getMetadata(int dmg)
   {
      return dmg;
   }
   
   @Override
   public String getUnlocalizedName(ItemStack stack)
   {
      return getUnlocalizedName() + "." + subNames[stack.getItemDamage()];
   }
}
