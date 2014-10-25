package gaiasbounty.recipe;

import gaiasbounty.block.BlockManager;
import gaiasbounty.item.ItemManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemsGB
{
   public static final ItemStack BUCKET_MILK       = new ItemStack(Items.milk_bucket, 1, 0);
   public static final ItemStack CHARCOAL          = new ItemStack(Items.coal, 1, 1);
   public static final ItemStack HAND_CHURN        = new ItemStack(ItemManager.churn, 1, OreDictionary.WILDCARD_VALUE);
   public static final ItemStack HONEY_PORK_COOKED = new ItemStack(ItemManager.foodPrepared, 1, 2);
   public static final ItemStack HONEY_PORK_RAW    = new ItemStack(ItemManager.foodPrepared, 1, 3);
   public static final ItemStack INGOT_IRON        = new ItemStack(Items.iron_ingot, 1, 0);
   public static final ItemStack KNIFE             = new ItemStack(ItemManager.knife, 1, OreDictionary.WILDCARD_VALUE);
   public static final ItemStack LATEX             = new ItemStack(ItemManager.material, 1, 3);
   public static final ItemStack LEAF_TEA          = new ItemStack(ItemManager.material, 1, 6);
   public static final ItemStack LEAVES_TEA        = new ItemStack(BlockManager.leaves6, 1, 1);
   public static final ItemStack LOG_ALMOND        = new ItemStack(BlockManager.logs4, 1, 3);
   public static final ItemStack LOG_APPLE         = new ItemStack(BlockManager.logs1, 1, 0);
   public static final ItemStack LOG_BANANA        = new ItemStack(BlockManager.logs1, 1, 3);
   public static final ItemStack LOG_CHERRY        = new ItemStack(BlockManager.logs1, 1, 2);
   public static final ItemStack LOG_FIG           = new ItemStack(BlockManager.logs3, 1, 3);
   public static final ItemStack LOG_HAZELNUT      = new ItemStack(BlockManager.logs4, 1, 1);
   public static final ItemStack LOG_LEMON         = new ItemStack(BlockManager.logs2, 1, 1);
   public static final ItemStack LOG_LIME          = new ItemStack(BlockManager.logs2, 1, 2);
   public static final ItemStack LOG_MACADAMIA     = new ItemStack(BlockManager.logs5, 1, 0);
   public static final ItemStack LOG_MANGO         = new ItemStack(BlockManager.logs3, 1, 0);
   public static final ItemStack LOG_MAPLE         = new ItemStack(BlockManager.logs6, 1, 3);
   public static final ItemStack LOG_MESQUITE      = new ItemStack(BlockManager.logs5, 1, 1);
   public static final ItemStack LOG_OLIVE         = new ItemStack(BlockManager.logs5, 1, 2);
   public static final ItemStack LOG_ORANGE        = new ItemStack(BlockManager.logs2, 1, 0);
   public static final ItemStack LOG_PALM          = new ItemStack(BlockManager.logs5, 1, 3);
   public static final ItemStack LOG_PEACH         = new ItemStack(BlockManager.logs1, 1, 1);
   public static final ItemStack LOG_PEAR          = new ItemStack(BlockManager.logs3, 1, 1);
   public static final ItemStack LOG_PECAN         = new ItemStack(BlockManager.logs4, 1, 2);
   public static final ItemStack LOG_PLUM          = new ItemStack(BlockManager.logs2, 1, 3);
   public static final ItemStack LOG_POMEGRANATE   = new ItemStack(BlockManager.logs3, 1, 2);
   public static final ItemStack LOG_RUBBER        = new ItemStack(BlockManager.logs6, 1, 2);
   public static final ItemStack LOG_SASSAFRAS     = new ItemStack(BlockManager.logs6, 1, 0);
   public static final ItemStack LOG_TEA           = new ItemStack(BlockManager.logs6, 1, 1);
   public static final ItemStack LOG_WALNUT        = new ItemStack(BlockManager.logs4, 1, 0);
   public static final ItemStack MAPLE_SAP         = new ItemStack(ItemManager.material, 1, 5);
   public static final ItemStack MESQUITE_BEANS    = new ItemStack(ItemManager.material, 1, 0);
   public static final ItemStack MESQUITE_CHARCOAL = new ItemStack(ItemManager.material, 1, 1);
}
