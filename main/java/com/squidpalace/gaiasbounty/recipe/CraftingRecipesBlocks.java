package com.squidpalace.gaiasbounty.recipe;

import com.squidpalace.gaiasbounty.block.BlockManager;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingRecipesBlocks
{
    public static void addRecipes()
    {
        CraftingManager crafting = CraftingManager.getInstance();
        List recipes = crafting.getRecipeList();

        // Logs -> Planks
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 0),
                ItemsGB.LOG_APPLE);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 1),
                ItemsGB.LOG_PEACH);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 2),
                ItemsGB.LOG_CHERRY);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 3),
                ItemsGB.LOG_BANANA);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 4),
                ItemsGB.LOG_ORANGE);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 5),
                ItemsGB.LOG_LEMON);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 6),
                ItemsGB.LOG_LIME);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 7),
                ItemsGB.LOG_PLUM);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 8),
                ItemsGB.LOG_MANGO);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 9),
                ItemsGB.LOG_PEAR);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 10),
                ItemsGB.LOG_POMEGRANATE);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 11),
                ItemsGB.LOG_FIG);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 12),
                ItemsGB.LOG_WALNUT);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 13),
                ItemsGB.LOG_HAZELNUT);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 14),
                ItemsGB.LOG_PECAN);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks1, 4, 15),
                ItemsGB.LOG_ALMOND);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 0),
                ItemsGB.LOG_MACADAMIA);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 1),
                ItemsGB.LOG_MESQUITE);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 2),
                ItemsGB.LOG_OLIVE);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 3),
                ItemsGB.LOG_PALM);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 4),
                ItemsGB.LOG_SASSAFRAS);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 5),
                ItemsGB.LOG_TEA);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 6),
                ItemsGB.LOG_RUBBER);
        crafting.addShapelessRecipe(new ItemStack(BlockManager.planks2, 4, 7),
                ItemsGB.LOG_MAPLE);
    }
}
