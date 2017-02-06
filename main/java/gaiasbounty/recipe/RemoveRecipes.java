package gaiasbounty.recipe;

import gaiasbounty.GaiasBounty;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RemoveRecipes
{
    public static void removeRecipes() {}

    private static void removeRecipe(ItemStack resultItem)
    {
        ItemStack recipeResult = null;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance()
                .getRecipeList();

        for (int scan = 0; scan < recipes.size(); scan++)
        {
            IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
            recipeResult = tmpRecipe.getRecipeOutput();

            if (recipeResult != null)
            {
                if (recipeResult.getItem() == resultItem.getItem()
                        && recipeResult.getItemDamage() == resultItem
                        .getItemDamage())
                {
                    GaiasBounty.consoleMessage("Removed crafting recipe: "
                            + recipes.get(scan) + " -> " + recipeResult);
                    recipes.remove(scan);
                    scan--; // list is shifted after remove! Adjust index, so
                    // next
                    // time we will check this value again.
                }
            }
        }
    }
}
