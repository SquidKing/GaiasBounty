package gaiasbounty.item;

import gaiasbounty.lib.Reference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodMulti extends ItemFood
{
   protected class FoodData
   {
      String subName;
      int foodValue;
      float saturation;
      boolean drink;
      boolean alwaysUsable;
      Item container;
      int useDuration;
      int rarity;
      ArrayList<PotionEffect> potionEffects;
      
      FoodData(String n, int f, float s, boolean d, boolean a, Item c,
               PotionEffect... params)
      {
         subName = n;
         foodValue = f;
         saturation = s;
         drink = d;
         alwaysUsable = a;
         container = c;
         useDuration = 32;
         rarity = 0;
         potionEffects = new ArrayList(0);
         
         if (params.length > 0 || params == null)
         {
            for (int i = 0; i < params.length; i++)
            {
               if (params[i] == null)
               {
                  break;
               }
               
               potionEffects.add(params[i]);
            }
         }
      }
   }
   
   ArrayList<FoodData> foodList;
   @SideOnly(Side.CLIENT) private IIcon[] iconArray;
   
   public ItemFoodMulti(boolean wolfFood)
   {
      super(0, 0.0F, wolfFood);
      foodList = new ArrayList();
      setHasSubtypes(true);
      setMaxDamage(0);
   }
   
   @Override
   public String getUnlocalizedName(ItemStack itemStack)
   {
      return getUnlocalizedName() + "."
               + foodList.get(itemStack.getItemDamage()).subName;
   }
   
   @Override
   public IIcon getIconFromDamage(int dmg)
   {
      int index = MathHelper.clamp_int(dmg, 0, foodList.size());
      return this.iconArray[index];
   }
   
   public int getMetaForType(String type)
   {
      for (int i = 0; i < foodList.size(); ++i)
      {
         if (foodList.get(i).subName.equals(type))
         {
            return i;
         }
      }
      
      return -1;
   }
   
   @Override
   public ItemStack onEaten(ItemStack itemStack, World world,
            EntityPlayer player)
   {
      int dmg = itemStack.getItemDamage();
      FoodData foodData = foodList.get(dmg);
      
      if (foodData == null)
      {
         return itemStack;
      }
      
      --itemStack.stackSize;
      player.getFoodStats().addStats(foodData.foodValue, foodData.saturation);
      
      if (!world.isRemote && foodData.potionEffects != null
               && foodData.potionEffects.size() > 0)
      {
         Iterator i = foodData.potionEffects.iterator();
         
         while (i.hasNext())
         {
            PotionEffect effect = (PotionEffect) i.next();
            PotionEffect newEffect = new PotionEffect(effect.getPotionID(),
                     effect.getDuration(), effect.getAmplifier());
            player.addPotionEffect(newEffect);
         }
      }
      
      if (!this.foodList.get(dmg).drink)
         world.playSoundAtEntity(player, "random.burp", 0.5F,
                  world.rand.nextFloat() * 0.1F + 0.9F);
      
      if (this.foodList.get(dmg).container != null)
      {
         if (itemStack.stackSize <= 0)
         {
            return new ItemStack(this.foodList.get(dmg).container, 1, 0);
         }
         
         player.inventory.addItemStackToInventory(new ItemStack(this.foodList
                  .get(dmg).container, 1, 0));
      }
      
      return itemStack;
   }
   
   @Override
   public int getMaxItemUseDuration(ItemStack itemStack)
   {
      return foodList.get(itemStack.getItemDamage()).useDuration;
   }
   
   @Override
   public EnumAction getItemUseAction(ItemStack itemStack)
   {
      int dmg = itemStack.getItemDamage();
      return this.foodList.get(dmg).drink ? EnumAction.drink : EnumAction.eat;
   }
   
   @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world,
            EntityPlayer player)
   {
      int dmg = itemStack.getItemDamage();
      
      if (player.canEat(this.foodList.get(dmg).alwaysUsable))
      {
         player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
      }
      
      return itemStack;
   }

   @SideOnly(Side.CLIENT)
   public EnumRarity getRarity(ItemStack itemStack)
   {
      int rarity = foodList.get(itemStack.getItemDamage()).rarity;
      if (rarity == 0) return EnumRarity.common;
      if (rarity == 1) return EnumRarity.uncommon;
      if (rarity == 2) return EnumRarity.rare;
      if (rarity == 3) return EnumRarity.epic;
      return EnumRarity.common;
   }
   
   public ItemFood setPotionEffect(int id, int duration, int amplifier,
            float probability)
   {
      return this;
   }
   
   public ItemFood setAlwaysEdible()
   {
      return this;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void getSubItems(Item item, CreativeTabs tab, List itemList)
   {
      int numFoodItems = this.foodList.size();
      
      for (int i = 0; i < numFoodItems; i++)
      {
         itemList.add(new ItemStack(item, 1, i));
      }
   }
   
   public ItemFoodMulti addFoodType(String subName, int foodValue,
            float saturation)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, false, false,
               null, (PotionEffect) null));
      return this;
   }
   
   public ItemFoodMulti addFoodType(String subName, int foodValue,
            float saturation, Item container)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, false, false,
               container, (PotionEffect) null));
      return this;
   }
   
   public ItemFoodMulti addFoodType(String subName, int foodValue,
            float saturation, PotionEffect... params)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, false, false,
               null, params));
      return this;
   }
   
   public ItemFoodMulti addFoodType(String subName, int foodValue,
            float saturation, Item container, PotionEffect... params)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, false, false,
               container, params));
      return this;
   }
   
   public ItemFoodMulti addDrinkType(String subName, int foodValue,
            float saturation)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, true, true,
               ((Item)Item.itemRegistry.getObject("glass_bottle")),
               (PotionEffect) null));
      return this;
   }
   
   public ItemFoodMulti addDrinkType(String subName, PotionEffect... params)
   {
      foodList.add(new FoodData(subName, 0, 0.0F, true, true,
               ((Item)Item.itemRegistry.getObject("glass_bottle")),
               params));
      return this;
   }
   
   public ItemFoodMulti addDrinkType(String subName, int foodValue,
            float saturation, PotionEffect... params)
   {
      foodList.add(new FoodData(subName, foodValue, saturation, true, true,
               ((Item)Item.itemRegistry.getObject("glass_bottle")),
               params));
      return this;
   }
   
   public void setAlwaysUsable(int i, boolean usable)
   {
      foodList.get(i).alwaysUsable = usable;
   }
   
   public void setUseDuration(int i, int duration)
   {
      foodList.get(i).useDuration = duration;
   }
   
   public void setRarity(int i, int rarity)
   {
      foodList.get(i).rarity = rarity;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister icons)
   {
      this.iconArray = new IIcon[foodList.size()];
      
      for (int i = 0; i < foodList.size(); ++i)
      {
         this.iconArray[i] = icons.registerIcon(Reference.GB_TEX_PREFIX
                  + foodList.get(i).subName);
      }
   }
}
