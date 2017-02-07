package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.block.BlockManager;
import com.squidpalace.gaiasbounty.lib.Reference;
import net.minecraft.block.Block;

public class ItemLeaves3 extends ItemMultiBlock
{
    public ItemLeaves3(Block block)
    {
        super(block);
        subNames = BlockManager.tree3Subtypes;
        setUnlocalizedName(Reference.GB_NAME_PREFIX + "leaves3");
    }
}
