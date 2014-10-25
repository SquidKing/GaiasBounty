package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemPlanks1 extends ItemMultiBlock
{
   public ItemPlanks1(Block block)
   {
      super(block);
      subNames = BlockManager.planks1Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "planks1");
   }
}