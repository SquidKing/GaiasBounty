package com.squidpalace.gaiasbounty.village;

import com.squidpalace.gaiasbounty.config.ConfigManager;

public class VillageManager
{
    public static void init()
    {
        VillagerGrocer.init(ConfigManager.villagerGrocerID);
    }
}
