package com.squidpalace.gaiasbounty.recipe;

public class RecipeManager
{
    public static void init()
    {
        OreDictEntries.addOreDictEntries();
        RemoveRecipes.removeRecipes();
        CraftingRecipesBlocks.addRecipes();
        CraftingRecipesItems.addRecipes();
        SmeltingRecipes.addRecipes();
        SmeltingFuels.addFuelHandler();
    }
}
