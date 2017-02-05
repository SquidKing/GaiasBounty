package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemPlanks2 extends ItemMultiBlock
{
   public ItemPlanks2(Block block)
   {
      super(block);
      subNames = BlockManager.planks2Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "planks2");
   }
}