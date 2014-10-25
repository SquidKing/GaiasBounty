package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLeaves5 extends ItemMultiBlock
{
   public ItemLeaves5(Block block)
   {
      super(block);
      subNames = BlockManager.tree5Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves5");
   }
}
