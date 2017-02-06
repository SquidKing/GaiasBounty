package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLogs3 extends ItemMultiBlock
{
    public ItemLogs3(Block block)
    {
        super(block);
        subNames = BlockManager.tree3Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs3");
    }
}
