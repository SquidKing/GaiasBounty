package gaiasbounty.block;

import static net.minecraftforge.common.EnumPlantType.Crop;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropsStandard extends BlockCrops
{
   public BlockCropsStandard()
   {
      super();
   }
   
   @Override
   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
   {
      return Crop;
   }
}
