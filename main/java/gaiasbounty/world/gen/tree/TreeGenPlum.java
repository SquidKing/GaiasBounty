package gaiasbounty.world.gen.tree;

import gaiasbounty.block.BlockManager;
import gaiasbounty.world.gen.shape.ShapeGenTreeVanilla;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeGenPlum extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      return ShapeGenTreeVanilla.instance.generate(world, rand, x, y, z,
               BlockManager.logs2, 3, BlockManager.leaves2, 3);
   }
}
