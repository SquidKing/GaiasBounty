package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLeaves6 extends ItemMultiBlock
{
   public ItemLeaves6(Block block)
   {
      super(block);
      subNames = BlockManager.tree6Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves6");
   }
}
