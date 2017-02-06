package gaiasbounty.village;

import gaiasbounty.config.ConfigManager;

public class VillageManager
{
    public static void init()
    {
        VillagerGrocer.init(ConfigManager.villagerGrocerID);
    }
}
