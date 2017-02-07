package com.squidpalace.gaiasbounty.recipe;

import com.squidpalace.gaiasbounty.item.ItemManager;

import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingRecipesItems
{
    public static void addRecipes()
    {
        CraftingManager crafting = CraftingManager.getInstance();
        List recipes = crafting.getRecipeList();

        // Vanilla items
        recipes.add(new ShapelessOreRecipe(new ItemStack(Items.bowl, 2), "cropCoconut", ItemsGB.KNIFE));
        recipes.add(new ShapedOreRecipe(new ItemStack(Items.paper, 2), "aaa", 'a', "cropAgave"));
        recipes.add(new ShapedOreRecipe(new ItemStack(Items.string, 2), "a", "a", "a", 'a', "cropAgave"));

        // Tea Leaves Block -> Tea Leaf Item
        crafting.addShapelessRecipe(new ItemStack(ItemManager.material, 1, 6),
                ItemsGB.LEAVES_TEA);

        // Eggs -> Raw Egg
        crafting.addShapelessRecipe(new ItemStack(ItemManager.foodIngredient, 1, 7),
                new ItemStack(Items.egg));

        // Tools
        recipes.add(new ShapedOreRecipe(new ItemStack(ItemManager.spigot, 1),
                true, " s ", "ipp", "  p", 's', "stickWood", 'i',
                ItemsGB.INGOT_IRON, 'p', "plankWood"));
        recipes.add(new ShapedOreRecipe(ItemsGB.HAND_CHURN,
                "psp", "psp", " p ", 'p', "plankWood", 's', "stickWood"));
        recipes.add(new ShapedOreRecipe(new ItemStack(ItemManager.knife, 1),
                "i", "r", 'i', "ingotIron", 'r', "itemRubber"));
        crafting.addShapelessRecipe(new ItemStack(ItemManager.foodIngredient, 1, 3),
                ItemsGB.HAND_CHURN, ItemsGB.BUCKET_MILK);
    }
}
