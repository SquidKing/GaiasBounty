package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLogs1 extends ItemMultiBlock
{
    public ItemLogs1(Block block)
    {
        super(block);
        subNames = BlockManager.tree1Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "logs1");
    }
}
