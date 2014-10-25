package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenMesquite extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return StructureGenTreeTropFlat.instance.generate(world, rand, x, y, z,
               BlockManager.logs5, 1, BlockManager.leaves5, 1);
   }
}
