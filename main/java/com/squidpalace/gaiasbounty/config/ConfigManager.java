package com.squidpalace.gaiasbounty.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigManager
{
    public static Configuration config;

    public static final String CATEGORY_ACHIEVEMENT = "achievement";
    public static final String CATEGORY_INTEGRATION = "mod_integration";
    public static final String CATEGORY_EFFECT = "effect";
    public static final String CATEGORY_ENTITY = "entity";
    public static final String CATEGORY_WORLDGEN = "worldgen";

    public static int gasID;

    public static int villagerGrocerID;

    public static boolean canGenTreeApple;
    public static boolean canGenTreePeach;
    public static boolean canGenTreeCherry;
    public static boolean canGenTreeBanana;
    public static boolean canGenTreeOrange;
    public static boolean canGenTreeLemon;
    public static boolean canGenTreeLime;
    public static boolean canGenTreePlum;
    public static boolean canGenTreeMango;
    public static boolean canGenTreePear;
    public static boolean canGenTreePomegranate;
    public static boolean canGenTreeFig;
    public static boolean canGenTreeWalnut;
    public static boolean canGenTreeHazelnut;
    public static boolean canGenTreePecan;
    public static boolean canGenTreeAlmond;
    public static boolean canGenTreeMacadamia;
    public static boolean canGenTreeMesquite;
    public static boolean canGenTreeOlive;
    public static boolean canGenTreePalm;
    public static boolean canGenTreeSassafras;
    public static boolean canGenTreeTea;
    public static boolean canGenTreeRubber;
    public static boolean canGenTreeMaple;

    public static void init(File configFile)
    {
        config = new Configuration(configFile);
        config.load();

        gasID = config.get(CATEGORY_EFFECT, "gas", 70).getInt(-1);
        villagerGrocerID = config.get(CATEGORY_ENTITY, "villagerGrocer", true).getInt(97470);

        canGenTreeApple = config.get(CATEGORY_WORLDGEN, "treeApple", true).getBoolean(true);
        canGenTreePeach = config.get(CATEGORY_WORLDGEN, "treePeach", true).getBoolean(true);
        canGenTreeCherry = config.get(CATEGORY_WORLDGEN, "treeCherry", true).getBoolean(true);
        canGenTreeBanana = config.get(CATEGORY_WORLDGEN, "treeBanana", true).getBoolean(true);
        canGenTreeOrange = config.get(CATEGORY_WORLDGEN, "treeOrange", true).getBoolean(true);
        canGenTreeApple = config.get(CATEGORY_WORLDGEN, "treeApple", true).getBoolean(true);
        canGenTreeLime = config.get(CATEGORY_WORLDGEN, "treeLime", true).getBoolean(true);
        canGenTreePlum = config.get(CATEGORY_WORLDGEN, "treePlum", true).getBoolean(true);
        canGenTreeMango = config.get(CATEGORY_WORLDGEN, "treeMango", true).getBoolean(true);
        canGenTreePear = config.get(CATEGORY_WORLDGEN, "treePear", true).getBoolean(true);
        canGenTreePomegranate = config.get(CATEGORY_WORLDGEN, "treePomegranate", true).getBoolean(true);
        canGenTreeFig = config.get(CATEGORY_WORLDGEN, "treeFig", true).getBoolean(true);
        canGenTreeWalnut = config.get(CATEGORY_WORLDGEN, "treeWalnut", true).getBoolean(true);
        canGenTreeHazelnut = config.get(CATEGORY_WORLDGEN, "treeHazelnut", true).getBoolean(true);
        canGenTreePecan = config.get(CATEGORY_WORLDGEN, "treePecan", true).getBoolean(true);
        canGenTreeAlmond = config.get(CATEGORY_WORLDGEN, "treeAlmond", true).getBoolean(true);
        canGenTreeMacadamia = config.get(CATEGORY_WORLDGEN, "treeMacadamia", true).getBoolean(true);
        canGenTreeMesquite = config.get(CATEGORY_WORLDGEN, "treeMesquite", true).getBoolean(true);
        canGenTreeOlive = config.get(CATEGORY_WORLDGEN, "treeOlive", true).getBoolean(true);
        canGenTreePalm = config.get(CATEGORY_WORLDGEN, "treePalm", true).getBoolean(true);
        canGenTreeSassafras = config.get(CATEGORY_WORLDGEN, "treeSassafras", true).getBoolean(true);
        canGenTreeTea = config.get(CATEGORY_WORLDGEN, "treeTea", true).getBoolean(true);
        canGenTreeRubber = config.get(CATEGORY_WORLDGEN, "treeRubber", true).getBoolean(true);
        canGenTreeMaple = config.get(CATEGORY_WORLDGEN, "treeMaple", true).getBoolean(true);

        config.save();
    }
}
