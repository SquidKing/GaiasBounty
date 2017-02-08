package com.squidpalace.gaiasbounty.item;

import com.squidpalace.gaiasbounty.lib.CreativeTabsGB;
import com.squidpalace.gaiasbounty.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeedsGeneric extends Item implements IPlantable
{
    private Block cropBlock;
    private Block soilBlock;
    private String texName;

    public ItemSeedsGeneric(Block cropBlock, Block soilBlock, String texName)
    {
        this.cropBlock = cropBlock;
        this.soilBlock = soilBlock;
        this.texName = texName;
        this.setCreativeTab(CreativeTabsGB.PLANT);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ != 1) return false;
        else if (player.canPlayerEdit(x, y, z, p_77648_7_, itemStack) && player.canPlayerEdit(x, y + 1, z, p_77648_7_, itemStack))
        {
            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z))
            {
                world.setBlock(x, y + 1, z, this.cropBlock);
                --itemStack.stackSize;
                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icons)
    {
        this.itemIcon = icons.registerIcon(Reference.GB_TEX_PREFIX + this.texName);
    }
}
