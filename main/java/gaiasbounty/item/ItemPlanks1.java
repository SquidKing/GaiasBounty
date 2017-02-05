package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemPlanks1 extends ItemMultiBlock
{
   public ItemPlanks1(Block block)
   {
      super(block);
      subNames = BlockManager.planks1Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "planks1");
   }
}