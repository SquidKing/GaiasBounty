package gaiasbounty.item;

import gaiasbounty.block.BlockManager;
import gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves6 extends ItemMultiBlock
{
    public ItemLeaves6(Block block)
    {
        super(block);
        subNames = BlockManager.tree6Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves6");
    }
}
