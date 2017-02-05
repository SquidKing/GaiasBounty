package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves5 extends ItemMultiBlock
{
   public ItemLeaves5(Block block)
   {
      super(block);
      subNames = BlockManager.tree5Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves5");
   }
}
