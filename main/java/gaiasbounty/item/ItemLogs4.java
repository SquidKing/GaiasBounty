package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLogs4 extends ItemMultiBlock
{
   public ItemLogs4(Block block)
   {
      super(block);
      subNames = BlockManager.tree4Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs4");
   }
}
