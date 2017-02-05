package gaiasbounty.potion;

import gaiasbounty.GaiasBounty;
import gaiasbounty.config.ConfigManager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.potion.Potion;

import org.apache.logging.log4j.Level;

public class PotionGB extends Potion
{
   public static PotionGB gas;
   
   protected PotionGB(int id, boolean badEffect, int colour)
   {
      super(id, badEffect, colour);
   }
   
   public static void init()
   {
      overridePotionTypeArray();
      
      gas = new PotionGB(ConfigManager.gasID, true, 0x849a3a);
      gas.setIconIndex(3, 1).setPotionName("potion.gaiasbounty.gas");
   }
   
   private static void overridePotionTypeArray()
   {
      Potion[] potionTypes = null;
      for (Field f : Potion.class.getDeclaredFields())
      {
         f.setAccessible(true);
         try
         {
            if (f.getName().equals("potionTypes")
                     || f.getName().equals("field_76425_a"))
            {
               Field m = Field.class.getDeclaredField("modifiers");
               m.setAccessible(true);
               m.setInt(f, f.getModifiers() & ~Modifier.FINAL);
               
               potionTypes = (Potion[])f.get(null);
               final Potion[] newPotionTypes = new Potion[256];
               System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
               f.set(null, newPotionTypes);
            }
         } catch (Exception e)
         {
            GaiasBounty.consoleMessage(Level.WARN, "Could not override potion array!");
            System.err.println(e);
         }
      }
   }
   
   protected Potion setIconIndex(int x, int y)
   {
      super.setIconIndex(x, y);
      return this;
   }
}
