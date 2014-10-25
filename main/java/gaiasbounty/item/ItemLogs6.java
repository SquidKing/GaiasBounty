package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLogs6 extends ItemMultiBlock
{
   public ItemLogs6(Block block)
   {
      super(block);
      subNames = BlockManager.tree6Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs6");
   }
}
