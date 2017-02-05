package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves2 extends ItemMultiBlock
{
   public ItemLeaves2(Block block)
   {
      super(block);
      subNames = BlockManager.tree2Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves2");
   }
}
