package gaiasbounty.block;

import java.util.Random;

import net.minecraft.world.World;

public interface IFertilizeable
{
   /**
    * Fertilizes the block. Automatically called when bonemeal is used.
    * @param world
    * @param rand
    * @param x
    * @param y
    * @param z
    * @return True if the block could be fertilized (but may not have grown)
    */
   public abstract boolean fertilize(World world, Random rand, int x, int y, int z);
}
