package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLogs3 extends ItemMultiBlock
{
   public ItemLogs3(Block block)
   {
      super(block);
      subNames = BlockManager.tree3Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs3");
   }
}
