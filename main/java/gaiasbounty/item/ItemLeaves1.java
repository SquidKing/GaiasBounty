package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLeaves1 extends ItemMultiBlock
{
   public ItemLeaves1(Block block)
   {
      super(block);
      subNames = BlockManager.tree1Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves1");
   }
}
