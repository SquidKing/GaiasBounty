package gaiasbounty.item;

import net.minecraft.block.Block;
import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;

public class ItemLogs5 extends ItemMultiBlock
{
   public ItemLogs5(Block block)
   {
      super(block);
      subNames = BlockManager.tree5Subtypes;
      setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs5");
   }
}
