package com.squidpalace.gaiasbounty.block;

import com.squidpalace.gaiasbounty.lib.CreativeTabsGB;
import com.squidpalace.gaiasbounty.lib.Reference;
import com.squidpalace.gaiasbounty.item.*;
import com.squidpalace.gaiasbounty.world.gen.tree.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager
{
    public static Block flower;
    public static Block saplings1;
    public static Block saplings2;
    public static Block saplings3;
    public static Block saplings4;
    public static Block saplings5;
    public static Block saplings6;
    public static Block leaves1;
    public static Block leaves2;
    public static Block leaves3;
    public static Block leaves4;
    public static Block leaves5;
    public static Block leaves6;
    public static Block logs1;
    public static Block logs2;
    public static Block logs3;
    public static Block logs4;
    public static Block logs5;
    public static Block logs6;
    public static Block logsSap;
    public static Block planks1;
    public static Block planks2;
    public static Block treefruit1;
    public static Block treefruit2;
    public static Block treefruit3;
    public static Block treefruit4;
    public static Block treefruit5;
    public static Block trellis;
    public static Block basaltSand;

    public static Block cropGrapeRed;
    public static Block cropGrapeGreen;
    public static Block cropStrawberry;
    public static Block cropTomato;
    public static Block cropRice;
    public static Block cropCorn;
    public static Block cropFlax;
    public static Block cropGinger;

    public static String[] tree1Subtypes =
            {"apple", "peach", "cherry", "banana"};
    public static String[] tree2Subtypes =
            {"orange", "lemon", "lime", "plum"};
    public static String[] tree3Subtypes =
            {"mango", "pear", "pomegranate", "fig"};
    public static String[] tree4Subtypes =
            {"walnut", "hazelnut", "pecan", "almond"};
    public static String[] tree5Subtypes =
            {"macadamia", "mesquite", "olive", "palm"};
    public static String[] tree6Subtypes =
            {"sassafras", "tea", "rubber", "maple"};

    public static String[] planks1Subtypes =
            {"apple", "peach", "cherry", "banana", "orange", "lemon", "lime",
                    "plum", "mango", "pear", "pomegranate", "fig", "walnut",
                    "hazelnut", "pecan", "almond"};

    public static String[] planks2Subtypes =
            {"macadamia", "mesquite", "olive", "palm", "sassafras", "tea", "rubber",
                    "maple"};

    public static void addBlocks()
    {
        saplings1 = new BlockSapling(tree1Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings1").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings1).setTreeGenerators(new TreeGenApple(),
                new TreeGenPeach(), new TreeGenCherry(), new TreeGenBanana());
        GameRegistry.registerBlock(saplings1, ItemSapling1.class, "saplings1");
        saplings2 = new BlockSapling(tree2Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings2").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings2).setTreeGenerators(new TreeGenOrange(),
                new TreeGenLemon(), new TreeGenLime(), new TreeGenPlum());
        GameRegistry.registerBlock(saplings2, ItemSapling2.class, "saplings2");
        saplings3 = new BlockSapling(tree3Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings3").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings3).setTreeGenerators(new TreeGenMango(),
                new TreeGenPear(), new TreeGenPomegranate(), new TreeGenFig());
        GameRegistry.registerBlock(saplings3, ItemSapling3.class, "saplings3");
        saplings4 = new BlockSapling(tree4Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings4").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings4).setTreeGenerators(new TreeGenWalnut(),
                new TreeGenHazelnut(), new TreeGenPecan(), new TreeGenAlmond());
        GameRegistry.registerBlock(saplings4, ItemSapling4.class, "saplings4");
        saplings5 = new BlockSapling(tree5Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings5").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings5).setTreeGenerators(new TreeGenMacadamia(),
                new TreeGenMesquite(), new TreeGenOlive(), new TreeGenPalm());
        GameRegistry.registerBlock(saplings5, ItemSapling5.class, "saplings5");
        saplings6 = new BlockSapling(tree6Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "saplings6").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockSapling) saplings6).setTreeGenerators(new TreeGenSassafras(),
                new TreeGenTea(), new TreeGenRubber(), new TreeGenMaple());
        GameRegistry.registerBlock(saplings6, ItemSapling6.class, "saplings6");

        logs1 = new BlockLogStandard(tree1Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs1").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs1, ItemLogs1.class, "logs1");
        logs2 = new BlockLogStandard(tree2Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs2").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs2, ItemLogs2.class, "logs2");
        logs3 = new BlockLogStandard(tree3Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs3").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs3, ItemLogs3.class, "logs3");
        logs4 = new BlockLogStandard(tree4Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs4").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs4, ItemLogs4.class, "logs4");
        logs5 = new BlockLogStandard(tree5Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs5").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs5, ItemLogs5.class, "logs5");
        logs6 = new BlockLogStandard(tree6Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "logs6").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logs6, ItemLogs6.class, "logs6");
        logsSap = new BlockSapLog("rubber", "maple").setBlockName(
                Reference.GB_NAME_PREFIX + "logsSap").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(logsSap, "logsSap");

        leaves1 = new BlockLeavesFruit(tree1Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves1").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves1).setSaplingItem(saplings1);
        GameRegistry.registerBlock(leaves1, ItemLeaves1.class, "leaves1");
        leaves2 = new BlockLeavesFruit(tree2Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves2").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves2).setSaplingItem(saplings2);
        GameRegistry.registerBlock(leaves2, ItemLeaves2.class, "leaves2");
        leaves3 = new BlockLeavesFruit(tree3Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves3").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves3).setSaplingItem(saplings3);
        GameRegistry.registerBlock(leaves3, ItemLeaves3.class, "leaves3");
        leaves4 = new BlockLeavesFruit(tree4Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves4").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves4).setSaplingItem(saplings4);
        GameRegistry.registerBlock(leaves4, ItemLeaves4.class, "leaves4");
        leaves5 = new BlockLeavesFruit(tree5Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves5").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves5).setSaplingItem(saplings5);
        ((BlockLeavesStandard) leaves5).setSaplingDropRates(20, 20, 20, 12);
        GameRegistry.registerBlock(leaves5, ItemLeaves5.class, "leaves5");
        leaves6 = new BlockLeavesStandard(tree6Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "leaves6").setCreativeTab(
                CreativeTabsGB.PLANT);
        ((BlockLeavesStandard) leaves6).setSaplingItem(saplings6);
        GameRegistry.registerBlock(leaves6, ItemLeaves6.class, "leaves6");

        treefruit1 = new BlockTreeFruit(tree1Subtypes)
                .setBlockName(Reference.GB_NAME_PREFIX + "treefruit1");
        GameRegistry.registerBlock(treefruit1, "treefruit1");
        treefruit2 = new BlockTreeFruit(tree2Subtypes)
                .setBlockName(Reference.GB_NAME_PREFIX + "treefruit2");
        GameRegistry.registerBlock(treefruit2, "treefruit2");
        treefruit3 = new BlockTreeFruit(tree3Subtypes)
                .setBlockName(Reference.GB_NAME_PREFIX + "treefruit3");
        GameRegistry.registerBlock(treefruit3, "treefruit3");
        treefruit4 = new BlockTreeFruit(tree4Subtypes)
                .setBlockName(Reference.GB_NAME_PREFIX + "treefruit4");
        GameRegistry.registerBlock(treefruit4, "treefruit4");
        treefruit5 = new BlockTreeFruit(tree5Subtypes)
                .setBlockName(Reference.GB_NAME_PREFIX + "treefruit5");
        GameRegistry.registerBlock(treefruit5, "treefruit5");

        planks1 = new BlockPlanks(planks1Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "planks1").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(planks1, ItemPlanks1.class, "planks1");
        planks2 = new BlockPlanks(planks2Subtypes).setBlockName(
                Reference.GB_NAME_PREFIX + "planks2").setCreativeTab(
                CreativeTabsGB.PLANT);
        GameRegistry.registerBlock(planks2, ItemPlanks2.class, "planks2");

        trellis = new BlockTrellis("trellis", "trellis_edge", Material.wood, true)
                .setStepSound(Block.soundTypeWood)
                .setBlockName(Reference.GB_NAME_PREFIX + "trellis")
                .setCreativeTab(CreativeTabsGB.MISC);
        GameRegistry.registerBlock(trellis, "trellis");

        basaltSand = new BlockBasaltSand().setBlockName(
                Reference.GB_NAME_PREFIX + "basaltSand").setCreativeTab(
                CreativeTabsGB.MISC);
        GameRegistry.registerBlock(basaltSand, "basaltSand");

        cropGrapeRed = new BlockCropsBase("grapes_red")
                .setBlockName(Reference.GB_NAME_PREFIX + "crop_grapes_red");
        GameRegistry.registerBlock(cropGrapeRed, "crop_grapes_red");
        cropGrapeGreen = new BlockCropsBase("grapes_green")
                .setBlockName(Reference.GB_NAME_PREFIX + "crop_grapes_green");
        GameRegistry.registerBlock(cropGrapeGreen, "crop_grapes_green");
        cropStrawberry = new BlockCropsBase("strawberry").setBlockName(Reference.GB_NAME_PREFIX + "crop_strawberry");
        GameRegistry.registerBlock(cropStrawberry, "crop_strawberry");
        cropTomato = new BlockCropsBase("tomato").setBlockName(Reference.GB_NAME_PREFIX + "crop_tomato");
        GameRegistry.registerBlock(cropTomato, "crop_tomato");
        cropRice= new BlockCropsBase("rice").setBlockName(Reference.GB_NAME_PREFIX + "crop_rice");
        GameRegistry.registerBlock(cropRice, "crop_rice");
        cropCorn = new BlockCropsBase("corn").setBlockName(Reference.GB_NAME_PREFIX + "crop_corn");
        GameRegistry.registerBlock(cropCorn, "crop_corn");
        cropFlax = new BlockCropsBase("flax").setBlockName(Reference.GB_NAME_PREFIX + "crop_flax");
        GameRegistry.registerBlock(cropFlax, "crop_flax");
        cropGinger = new BlockCropsBase("ginger").setBlockName(Reference.GB_NAME_PREFIX + "crop_ginger");
        GameRegistry.registerBlock(cropGinger, "crop_ginger");
    }

    public static void setBlockMiscData()
    {
        ((BlockCropsBase) cropGrapeRed).setSeedItem(new ItemStack(ItemManager.seedGrapeRed, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 18));
        ((BlockCropsBase) cropGrapeGreen).setSeedItem(new ItemStack(ItemManager.seedGrapeGreen, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 19));
        ((BlockCropsBase) cropStrawberry).setSeedItem(new ItemStack(ItemManager.seedStrawberry, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 24));
        ((BlockCropsBase) cropTomato).setSeedItem(new ItemStack(ItemManager.seedTomato, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 31));
        ((BlockCropsBase) cropRice).setSeedItem(new ItemStack(ItemManager.seedRice, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 32));
        ((BlockCropsBase) cropCorn).setSeedItem(new ItemStack(ItemManager.seedCorn, 1))
                .setProduceItem(new ItemStack(ItemManager.foodCrop, 1, 41));
        ((BlockCropsBase) cropFlax).setSeedItem(new ItemStack(ItemManager.seedFlax, 1))
                .setProduceItem(new ItemStack(ItemManager.material, 1, 11));
        ((BlockCropsBase) cropGinger).setSeedItem(new ItemStack(ItemManager.seedGinger, 1))
                .setProduceItem(new ItemStack(ItemManager.material, 1, 12));

        Blocks.fire.setFireInfo(logs1, 30, 60);
        Blocks.fire.setFireInfo(logs2, 30, 60);
        Blocks.fire.setFireInfo(logs3, 30, 60);
        Blocks.fire.setFireInfo(logs4, 30, 60);
        Blocks.fire.setFireInfo(logs5, 30, 60);
        Blocks.fire.setFireInfo(logs6, 30, 60);
        Blocks.fire.setFireInfo(logsSap, 30, 60);
        Blocks.fire.setFireInfo(leaves1, 30, 60);
        Blocks.fire.setFireInfo(leaves2, 30, 60);
        Blocks.fire.setFireInfo(leaves3, 30, 60);
        Blocks.fire.setFireInfo(leaves4, 30, 60);
        Blocks.fire.setFireInfo(leaves5, 30, 60);
        Blocks.fire.setFireInfo(leaves6, 30, 60);

        ((BlockSapLog) logsSap).setDrops(
                new ItemStack(ItemManager.material, 1, 3), new ItemStack(
                        ItemManager.material, 1, 5));

        ((BlockLeavesFruit) leaves1).setFruitBlock(treefruit1);
        ((BlockLeavesFruit) leaves2).setFruitBlock(treefruit2);
        ((BlockLeavesFruit) leaves3).setFruitBlock(treefruit3);
        ((BlockLeavesFruit) leaves4).setFruitBlock(treefruit4);
        ((BlockLeavesFruit) leaves5).setFruitBlock(treefruit5);

        ((BlockLeavesStandard) leaves1).setRareLeafDrops(new ItemStack(
                        Items.apple, 1, 0), 150, new ItemStack(ItemManager.foodCrop, 1,
                        0), 150, new ItemStack(ItemManager.foodCrop, 1, 1), 150,
                new ItemStack(ItemManager.foodCrop, 1, 2), 150);
        ((BlockLeavesStandard) leaves2).setRareLeafDrops(new ItemStack(
                ItemManager.foodCrop, 1, 3), 150, new ItemStack(
                ItemManager.foodCrop, 1, 4), 150, new ItemStack(
                ItemManager.foodCrop, 1, 5), 150, new ItemStack(
                ItemManager.foodCrop, 1, 6), 150);
        ((BlockLeavesStandard) leaves3).setRareLeafDrops(new ItemStack(
                ItemManager.foodCrop, 1, 7), 150, new ItemStack(
                ItemManager.foodCrop, 1, 8), 150, new ItemStack(
                ItemManager.foodCrop, 1, 9), 150, new ItemStack(
                ItemManager.foodCrop, 1, 10), 150);
        ((BlockLeavesStandard) leaves4).setRareLeafDrops(new ItemStack(
                ItemManager.foodCrop, 1, 11), 150, new ItemStack(
                ItemManager.foodCrop, 1, 12), 150, new ItemStack(
                ItemManager.foodCrop, 1, 13), 150, new ItemStack(
                ItemManager.foodCrop, 1, 14), 150);
        ((BlockLeavesStandard) leaves5).setRareLeafDrops(new ItemStack(
                ItemManager.foodCrop, 1, 15), 150, new ItemStack(
                ItemManager.material, 1, 0), 150, new ItemStack(
                ItemManager.foodCrop, 1, 16), 150, new ItemStack(
                ItemManager.foodCrop, 1, 17), 150);
        ((BlockLeavesStandard) leaves6).setRareLeafDrops(null, 1, new ItemStack(
                ItemManager.material, 1, 6), 3, null, 1, null, 1);

        ((BlockTreeFruit) treefruit1).setFruitItems(new ItemStack(Items.apple, 1,
                0), new ItemStack(ItemManager.foodCrop, 1, 0), new ItemStack(
                ItemManager.foodCrop, 1, 1), new ItemStack(ItemManager.foodCrop,
                1, 2));
        ((BlockTreeFruit) treefruit2).setFruitItems(new ItemStack(
                ItemManager.foodCrop, 1, 3), new ItemStack(ItemManager.foodCrop,
                1, 4), new ItemStack(ItemManager.foodCrop, 1, 5), new ItemStack(
                ItemManager.foodCrop, 1, 6));
        ((BlockTreeFruit) treefruit3).setFruitItems(new ItemStack(
                ItemManager.foodCrop, 1, 7), new ItemStack(ItemManager.foodCrop,
                1, 8), new ItemStack(ItemManager.foodCrop, 1, 9), new ItemStack(
                ItemManager.foodCrop, 1, 10));
        ((BlockTreeFruit) treefruit4).setFruitItems(new ItemStack(
                ItemManager.foodCrop, 1, 11), new ItemStack(
                ItemManager.foodCrop, 1, 12), new ItemStack(
                ItemManager.foodCrop, 1, 13), new ItemStack(
                ItemManager.foodCrop, 1, 14));
        ((BlockTreeFruit) treefruit5).setFruitItems(new ItemStack(
                ItemManager.foodCrop, 1, 15), new ItemStack(
                ItemManager.material, 1, 0), new ItemStack(ItemManager.foodCrop,
                1, 16), new ItemStack(ItemManager.foodCrop, 1, 17));
    }
}
