package com.squidpalace.gaiasbounty.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCraftingTool extends ItemToolGeneric
{
    Item baseItem;
    int baseMeta;

    public ItemCraftingTool(int durability, String texName, Item baseItem, int baseMeta)
    {
        super(durability, texName);
        this.setContainerItem(this);
        this.baseMeta = baseMeta;
        if (baseItem != null)
            this.baseItem = baseItem;
    }

    public ItemCraftingTool(int durability, String texName, Item baseItem)
    {
        this(durability, texName, baseItem, 0);
    }

    public ItemCraftingTool(int durability, String texName)
    {
        this(durability, texName, null, 0);
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack)
    {
        int damage = stack.getItemDamage();
        ItemStack damagedTool = null;

        if (damage < this.getMaxDamage())
        {
            damagedTool = stack.copy();
            damagedTool.setItemDamage(damage + 1);
        }

        if (damagedTool == null && this.baseItem != null)
            damagedTool = new ItemStack(baseItem, 1, baseMeta);

        return damagedTool;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack,
                               EntityPlayer player, List stringList, boolean par4)
    {
        int uses = this.getMaxDamage(stack) - stack.getItemDamage() + 1;
        stringList.add(StatCollector.translateToLocalFormatted(
                "item.gaiasbounty.tool.remaininguses", uses));
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
    {
        return false;
    }
}
