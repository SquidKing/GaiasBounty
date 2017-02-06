package gaiasbounty.recipe;

import gaiasbounty.block.BlockManager;
import gaiasbounty.item.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.MinecraftException;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictEntries
{
    public static void addOreDictEntries()
    {
        addTrees();
        addCrops();
        addMeats();
        addIngredients();
        addDishes();
        addMaterials();
    }

    private static void addTrees()
    {
        Block[] logs = {
                BlockManager.logs1, BlockManager.logs2, BlockManager.logs3,
                BlockManager.logs4, BlockManager.logs5, BlockManager.logs6
        };
        Block[] leaves = {
                BlockManager.leaves1, BlockManager.leaves2, BlockManager.leaves3,
                BlockManager.leaves4, BlockManager.leaves5, BlockManager.leaves6
        };
        Block[] saplings = {
                BlockManager.saplings1, BlockManager.saplings2, BlockManager.saplings3,
                BlockManager.saplings4, BlockManager.saplings5, BlockManager.saplings6
        };

        for (int i = 0; i < logs.length; i++)
            for (int j = 0; j < 4; j++)
                OreDictionary.registerOre("logWood", new ItemStack(logs[i], 1, j));
        for (int i = 0; i < 16; i++)
            OreDictionary.registerOre("plankWood", new ItemStack(BlockManager.planks1, 1, i));
        for (int i = 0; i < 7; i++)
            OreDictionary.registerOre("plankWood", new ItemStack(BlockManager.planks2, 1, i));
        for (int i = 0; i < leaves.length; i++)
            for (int j = 0; j < 4; j++)
                OreDictionary.registerOre("treeLeaves", new ItemStack(leaves[i], 1, j));
        for (int i = 0; i < saplings.length; i++)
            for (int j = 0; j < 4; j++)
                OreDictionary.registerOre("treeSapling", new ItemStack(saplings[i], 1, j));
    }

    private static void addCrops()
    {
        ItemStack melon = new ItemStack(Items.melon);
        ItemStack peach = new ItemStack(ItemManager.foodCrop, 1, 0);
        ItemStack cherry = new ItemStack(ItemManager.foodCrop, 1, 1);
        ItemStack banana = new ItemStack(ItemManager.foodCrop, 1, 2);
        ItemStack orange = new ItemStack(ItemManager.foodCrop, 1, 3);
        ItemStack lemon = new ItemStack(ItemManager.foodCrop, 1, 4);
        ItemStack lime = new ItemStack(ItemManager.foodCrop, 1, 5);
        ItemStack plum = new ItemStack(ItemManager.foodCrop, 1, 6);
        ItemStack mango = new ItemStack(ItemManager.foodCrop, 1, 7);
        ItemStack pear = new ItemStack(ItemManager.foodCrop, 1, 8);
        ItemStack pomegranate = new ItemStack(ItemManager.foodCrop, 1, 9);
        ItemStack fig = new ItemStack(ItemManager.foodCrop, 1, 10);
        ItemStack walnut = new ItemStack(ItemManager.foodCrop, 1, 11);
        ItemStack hazelnut = new ItemStack(ItemManager.foodCrop, 1, 12);
        ItemStack pecan = new ItemStack(ItemManager.foodCrop, 1, 13);
        ItemStack almond = new ItemStack(ItemManager.foodCrop, 1, 14);
        ItemStack macadamia = new ItemStack(ItemManager.foodCrop, 1, 15);
        ItemStack olive = new ItemStack(ItemManager.foodCrop, 1, 16);
        ItemStack coconut = new ItemStack(ItemManager.foodCrop, 1, 17);
        ItemStack grapeRed = new ItemStack(ItemManager.foodCrop, 1, 18);
        ItemStack grapeGreen = new ItemStack(ItemManager.foodCrop, 1, 19);
        ItemStack kiwi = new ItemStack(ItemManager.foodCrop, 1, 20);
        ItemStack cantaloupe = new ItemStack(ItemManager.foodCrop, 1, 21);
        ItemStack honeydew = new ItemStack(ItemManager.foodCrop, 1, 22);
        ItemStack gourd = new ItemStack(ItemManager.foodCrop, 1, 23);
        ItemStack strawberry = new ItemStack(ItemManager.foodCrop, 1, 24);
        ItemStack raspberry = new ItemStack(ItemManager.foodCrop, 1, 25);
        ItemStack blackberry = new ItemStack(ItemManager.foodCrop, 1, 26);
        ItemStack blueberry = new ItemStack(ItemManager.foodCrop, 1, 27);
        ItemStack saskatoonBerry = new ItemStack(ItemManager.foodCrop, 1, 28);
        ItemStack cranberry = new ItemStack(ItemManager.foodCrop, 1, 29);
        ItemStack pineapple = new ItemStack(ItemManager.foodCrop, 1, 30);
        ItemStack tomato = new ItemStack(ItemManager.foodCrop, 1, 31);
        ItemStack rice = new ItemStack(ItemManager.foodCrop, 1, 32);
        ItemStack beet = new ItemStack(ItemManager.foodCrop, 1, 33);
        ItemStack turnip = new ItemStack(ItemManager.foodCrop, 1, 34);
        ItemStack peanut = new ItemStack(ItemManager.foodCrop, 1, 35);
        ItemStack truffle = new ItemStack(ItemManager.foodCrop, 1, 36);
        ItemStack peas = new ItemStack(ItemManager.foodCrop, 1, 37);
        ItemStack cucumber = new ItemStack(ItemManager.foodCrop, 1, 38);
        ItemStack zucchini = new ItemStack(ItemManager.foodCrop, 1, 39);
        ItemStack beans = new ItemStack(ItemManager.foodCrop, 1, 40);
        ItemStack corn = new ItemStack(ItemManager.foodCrop, 1, 41);
        ItemStack lettuce = new ItemStack(ItemManager.foodCrop, 1, 42);
        ItemStack celery = new ItemStack(ItemManager.foodCrop, 1, 43);
        ItemStack cabbage = new ItemStack(ItemManager.foodCrop, 1, 44);
        ItemStack leek = new ItemStack(ItemManager.foodCrop, 1, 45);
        ItemStack rhubarb = new ItemStack(ItemManager.foodCrop, 1, 46);
        ItemStack broccoli = new ItemStack(ItemManager.foodCrop, 1, 47);
        ItemStack cauliflower = new ItemStack(ItemManager.foodCrop, 1, 48);
        ItemStack onion = new ItemStack(ItemManager.foodCrop, 1, 49);
        ItemStack bellPepperRed = new ItemStack(ItemManager.foodCrop, 1, 50);
        ItemStack bellPepperGreen = new ItemStack(ItemManager.foodCrop, 1, 51);
        ItemStack chiliPepper = new ItemStack(ItemManager.foodCrop, 1, 52);
        ItemStack agave = new ItemStack(ItemManager.foodCrop, 1, 53);

        OreDictionary.registerOre("cropPeach", peach);
        OreDictionary.registerOre("cropCherry", cherry);
        OreDictionary.registerOre("cropBanana", banana);
        OreDictionary.registerOre("cropOrange", orange);
        OreDictionary.registerOre("cropLemon", lemon);
        OreDictionary.registerOre("cropLime", lime);
        OreDictionary.registerOre("cropPlum", plum);
        OreDictionary.registerOre("cropMango", mango);
        OreDictionary.registerOre("cropPear", pear);
        OreDictionary.registerOre("cropPomegranate", pomegranate);
        OreDictionary.registerOre("cropFig", fig);
        OreDictionary.registerOre("cropWalnut", walnut);
        OreDictionary.registerOre("cropHazelnut", hazelnut);
        OreDictionary.registerOre("cropPecan", pecan);
        OreDictionary.registerOre("cropAlmond", almond);
        OreDictionary.registerOre("cropMacadamia", macadamia);
        OreDictionary.registerOre("cropOlive", olive);
        OreDictionary.registerOre("cropCoconut", coconut);
        OreDictionary.registerOre("cropGrape", grapeRed);
        OreDictionary.registerOre("cropGrapeGreen", grapeGreen);
        OreDictionary.registerOre("cropKiwi", kiwi);
        OreDictionary.registerOre("cropCantaloupe", cantaloupe);
        OreDictionary.registerOre("cropHoneydew", honeydew);
        OreDictionary.registerOre("cropGourd", gourd);
        OreDictionary.registerOre("cropStrawberry", strawberry);
        OreDictionary.registerOre("cropRaspberry", raspberry);
        OreDictionary.registerOre("cropBlackberry", blackberry);
        OreDictionary.registerOre("cropBlueberry", blueberry);
        OreDictionary.registerOre("cropSaskatoonberry", saskatoonBerry);
        OreDictionary.registerOre("cropCranberry", cranberry);
        OreDictionary.registerOre("cropPineapple", pineapple);
        OreDictionary.registerOre("cropTomato", tomato);
        OreDictionary.registerOre("cropRice", rice);
        OreDictionary.registerOre("cropBeet", beet);
        OreDictionary.registerOre("cropTurnip", turnip);
        OreDictionary.registerOre("cropPeanut", peanut);
        OreDictionary.registerOre("cropTruffle", truffle);
        OreDictionary.registerOre("cropPeas", peas);
        OreDictionary.registerOre("cropCucumber", cucumber);
        OreDictionary.registerOre("cropZucchini", zucchini);
        OreDictionary.registerOre("cropBean", beans);
        OreDictionary.registerOre("cropCorn", corn);
        OreDictionary.registerOre("cropLettuce", lettuce);
        OreDictionary.registerOre("cropCelery", celery);
        OreDictionary.registerOre("cropCabbage", cabbage);
        OreDictionary.registerOre("cropLeek", leek);
        OreDictionary.registerOre("cropRhubarb", rhubarb);
        OreDictionary.registerOre("cropBroccoli", broccoli);
        OreDictionary.registerOre("cropCauliflower", cauliflower);
        OreDictionary.registerOre("cropOnion", onion);
        OreDictionary.registerOre("cropBellpepperRed", bellPepperRed);
        OreDictionary.registerOre("cropBellpepper", bellPepperGreen);
        OreDictionary.registerOre("cropChilipepper", chiliPepper);
        OreDictionary.registerOre("cropAgave", agave);

        registerEntries("listAllfruit", new ItemStack[] {
                melon, peach, cherry, banana, orange, lemon, lime, plum, mango, pear, pomegranate, fig, grapeRed,
                grapeGreen, kiwi, cantaloupe, honeydew, strawberry, raspberry, blackberry, blueberry, saskatoonBerry,
                cranberry, pineapple
        });
        registerEntries("listAllmelon", new ItemStack[] {
                melon, cantaloupe, honeydew
        });
        registerEntries("listAllberry", new ItemStack[] {
                strawberry, raspberry, blackberry, blueberry, saskatoonBerry, cranberry
        });
        registerEntries("listAllcitrus", new ItemStack[] {
                orange, lemon, lime
        });
        registerEntries("listAllnut", new ItemStack[] {
                walnut, hazelnut, pecan, almond, macadamia, peanut
        });
        registerEntries("listAllveggie", new ItemStack[] {
                gourd, tomato, beet, turnip, peas, cucumber, zucchini, beans, corn, lettuce, celery, cabbage, leek,
                rhubarb, broccoli, cauliflower, onion, bellPepperRed, bellPepperGreen
        });
        registerEntries("listAllgreenveggie", new ItemStack[] {
                peas, cucumber, zucchini, lettuce, celery, cabbage, broccoli
        });
        OreDictionary.registerOre("listAllrootveggie", turnip);
        registerEntries("listAllpepper", new ItemStack[] {
                bellPepperRed, bellPepperGreen, chiliPepper
        });
    }

    private static void addMeats()
    {
        ItemStack porkRaw = new ItemStack (Items.porkchop);
        ItemStack beefRaw = new ItemStack(Items.beef);
        ItemStack chickenRaw = new ItemStack(Items.chicken);
        ItemStack horseRaw = new ItemStack(ItemManager.meat, 1, 0);
        ItemStack baconRaw = new ItemStack(ItemManager.meat, 1, 2);
        ItemStack bisonRaw = new ItemStack(ItemManager.meat, 1, 4);
        ItemStack turkeyRaw = new ItemStack(ItemManager.meat, 1, 6);
        ItemStack duckRaw = new ItemStack(ItemManager.meat, 1, 8);
        ItemStack venisonRaw = new ItemStack(ItemManager.meat, 1, 10);
        ItemStack muttonRaw = new ItemStack(ItemManager.meat, 1, 12);
        ItemStack squidRaw = new ItemStack(ItemManager.seafood, 1, 0);
        ItemStack prawnRaw = new ItemStack(ItemManager.seafood, 1, 2);
        ItemStack porkCooked = new ItemStack(Items.cooked_porkchop);
        ItemStack beefCooked = new ItemStack(Items.cooked_beef);
        ItemStack chickenCooked = new ItemStack(Items.cooked_chicken);
        ItemStack horseCooked = new ItemStack(ItemManager.meat, 1, 1);
        ItemStack baconCooked = new ItemStack(ItemManager.meat, 1, 3);
        ItemStack bisonCooked = new ItemStack(ItemManager.meat, 1, 5);
        ItemStack turkeyCooked = new ItemStack(ItemManager.meat, 1, 7);
        ItemStack duckCooked = new ItemStack(ItemManager.meat, 1, 9);
        ItemStack venisonCooked = new ItemStack(ItemManager.meat, 1, 11);
        ItemStack muttonCooked = new ItemStack(ItemManager.meat, 1, 13);
        ItemStack squidCooked = new ItemStack(ItemManager.seafood, 1, 1);
        ItemStack prawnCooked = new ItemStack(ItemManager.seafood, 1, 3);

        OreDictionary.registerOre("foodHorseraw", horseRaw);
        OreDictionary.registerOre("foodBaconraw", baconRaw);
        OreDictionary.registerOre("listAllporkraw", baconRaw);
        OreDictionary.registerOre("foodBisonraw", bisonRaw);
        OreDictionary.registerOre("foodTurkeyraw", turkeyRaw);
        OreDictionary.registerOre("listAllturkeyraw", turkeyRaw);
        OreDictionary.registerOre("foodDuckraw", duckRaw);
        OreDictionary.registerOre("foodVenisonraw", venisonRaw);
        OreDictionary.registerOre("listAllvenisonraw", venisonRaw);
        OreDictionary.registerOre("foodMuttonraw", muttonRaw);
        OreDictionary.registerOre("listAllmuttonraw", muttonRaw);
        OreDictionary.registerOre("foodCalamariraw", squidRaw);
        OreDictionary.registerOre("foodShrimpraw", prawnRaw);
        OreDictionary.registerOre("foodHorsecooked", horseCooked);
        OreDictionary.registerOre("foodBaconcooked", baconCooked);
        OreDictionary.registerOre("listAllporkcooked", baconCooked);
        OreDictionary.registerOre("foodBisoncooked", bisonCooked);
        OreDictionary.registerOre("foodTurkeycooked", turkeyCooked);
        OreDictionary.registerOre("listAllturkeycooked", turkeyCooked);
        OreDictionary.registerOre("foodDuckcooked", duckCooked);
        OreDictionary.registerOre("foodVenisoncooked", venisonCooked);
        OreDictionary.registerOre("listAllvenisoncooked", venisonCooked);
        OreDictionary.registerOre("foodMuttoncooked", muttonCooked);
        OreDictionary.registerOre("listAllmuttoncooked", muttonCooked);
        OreDictionary.registerOre("foodCalamaricooked", squidCooked);
        OreDictionary.registerOre("foodShrimpcooked", prawnCooked);

        registerEntries("listAllmeatraw", new ItemStack[] {
                horseRaw, baconRaw, bisonRaw, turkeyRaw, duckRaw, venisonRaw, muttonRaw
        });
        registerEntries("listAllredmeatraw", new ItemStack[] {
                porkRaw, beefRaw, horseRaw, baconRaw, bisonRaw, venisonRaw, muttonRaw
        });
        registerEntries("listAllpoultryraw", new ItemStack[] {
                chickenRaw, turkeyRaw, duckRaw
        });
        registerEntries("listAllfishraw", new ItemStack[] {
                squidRaw, prawnRaw
        });
        registerEntries("listAllmeatcooked", new ItemStack[] {
                horseCooked, baconCooked, bisonCooked, turkeyCooked, duckCooked, venisonCooked, muttonCooked
        });
        registerEntries("listAllredmeatcooked", new ItemStack[] {
                porkCooked, beefCooked, horseCooked, baconCooked, bisonCooked, venisonCooked, muttonCooked
        });
        registerEntries("listAllpoultrycooked", new ItemStack[] {
                chickenCooked, turkeyCooked, duckCooked
        });
        registerEntries("listAllfishcooked", new ItemStack[] {
                squidCooked, prawnCooked
        });
    }

    private static void addIngredients()
    {
        OreDictionary.registerOre("foodGherkin", new ItemStack(
                ItemManager.foodIngredient, 1, 0));
        OreDictionary.registerOre("foodRaisins", new ItemStack(
                ItemManager.foodIngredient, 1, 1));
        OreDictionary.registerOre("foodSultanas", new ItemStack(
                ItemManager.foodIngredient, 1, 2));
        OreDictionary.registerOre("foodButter", new ItemStack(
                ItemManager.foodIngredient, 1, 3));
        OreDictionary.registerOre("foodCheese", new ItemStack(
                ItemManager.foodIngredient, 1, 4));
        OreDictionary.registerOre("foodCaramel", new ItemStack(
                ItemManager.foodIngredient, 1, 5));
        OreDictionary.registerOre("foodChocolate", new ItemStack(
                ItemManager.foodIngredient, 1, 6));
        OreDictionary.registerOre("listAllegg", new ItemStack(
                ItemManager.foodIngredient, 1, 7));
    }

    private static void addDishes()
    {

    }

    private static void addMaterials()
    {
        ItemStack mesquite = new ItemStack(ItemManager.material, 1, 0);
        ItemStack mesquiteCharcoal = new ItemStack(ItemManager.material, 1, 1);
        ItemStack hops = new ItemStack(ItemManager.material, 1, 2);
        ItemStack latex = new ItemStack(ItemManager.material, 1, 3);
        ItemStack rubber = new ItemStack(ItemManager.material, 1, 4);
        ItemStack tea = new ItemStack(ItemManager.material, 1, 6);
        ItemStack mint = new ItemStack(ItemManager.material, 1, 7);
        ItemStack vanilla = new ItemStack(ItemManager.material, 1, 8);
        ItemStack garlic = new ItemStack(ItemManager.material, 1, 9);
        ItemStack cotton = new ItemStack(ItemManager.material, 1, 10);
        ItemStack flax = new ItemStack(ItemManager.material, 1, 11);

        OreDictionary.registerOre("cropMesquitebean", mesquite);
        OreDictionary.registerOre("charcoal", mesquiteCharcoal);
        OreDictionary.registerOre("cropHops", hops);
        OreDictionary.registerOre("itemRawRubber", latex);
        OreDictionary.registerOre("itemRubber", rubber);
        OreDictionary.registerOre("cropTea", tea);
        OreDictionary.registerOre("cropMint", mint);
        OreDictionary.registerOre("cropVanillabean", vanilla);
        OreDictionary.registerOre("cropGarlic", garlic);
        OreDictionary.registerOre("cropCotton", cotton);
        OreDictionary.registerOre("cropFlax", flax);

        registerEntries("listAllherb", new ItemStack[] {
                mint, garlic
        });
    }

    private static void registerEntries(String name, ItemStack[] items)
    {
        int length = items.length;
        for (int i = 0; i < length; i++)
            OreDictionary.registerOre(name, items[i]);
    }
}
