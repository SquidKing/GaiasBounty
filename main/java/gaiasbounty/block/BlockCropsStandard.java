package gaiasbounty.block;

import static net.minecraftforge.common.EnumPlantType.Crop;
import gaiasbounty.tileentity.TileEntityCrops;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropsStandard extends BlockCrops implements ITileEntityProvider
{
   public BlockCropsStandard()
   {
      super();
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side)
   {
      TileEntity myEntity = access.getTileEntity(x, y, z);
      int cropId = 0, meta = access.getBlockMetadata(x, y, z);
      
      if (myEntity instanceof TileEntityCrops)
         cropId = ((TileEntityCrops) myEntity).getCropId();
      
      return this.getIcon(side, access.getBlockMetadata(x, y, z));
   }
   
   @Override
   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
   {
      return Crop;
   }

   @Override
   public TileEntity createNewTileEntity(World world, int meta)
   {
      return new TileEntityCrops();
   }
}
