package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLeaves3 extends ItemMultiBlock
{
   public ItemLeaves3(Block block)
   {
      super(block);
      subNames = BlockManager.tree3Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves3");
   }
}
