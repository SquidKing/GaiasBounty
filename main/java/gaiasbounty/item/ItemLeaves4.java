package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLeaves4 extends ItemMultiBlock
{
   public ItemLeaves4(Block block)
   {
      super(block);
      subNames = BlockManager.tree4Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves4");
   }
}
