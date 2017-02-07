package com.squidpalace.gaiasbounty.entity;

import com.squidpalace.gaiasbounty.client.model.ModelBison;
import com.squidpalace.gaiasbounty.client.model.ModelDeer;
import com.squidpalace.gaiasbounty.client.model.ModelTurkey;
import com.squidpalace.gaiasbounty.client.render.RenderBison;
import com.squidpalace.gaiasbounty.client.render.RenderDeer;
import com.squidpalace.gaiasbounty.client.render.RenderDuck;
import com.squidpalace.gaiasbounty.client.model.ModelDuck;
import com.squidpalace.gaiasbounty.client.render.RenderTurkey;
import com.squidpalace.gaiasbounty.GaiasBounty;
import com.squidpalace.gaiasbounty.client.ClientTickHandler;

import java.util.ArrayList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager
{
    public static final int BISON_ID = 0, TURKEY_ID = 1, DUCK_ID = 2, DEER_ID = 3;

    public static void registerEntities()
    {
        // Bison
        EntityRegistry.registerModEntity(EntityBison.class, "gaiasbounty.bison",
                BISON_ID, GaiasBounty.instance, 80, 3, true);

        // Turkey
        EntityRegistry.registerModEntity(EntityTurkey.class, "gaiasbounty.turkey",
                TURKEY_ID, GaiasBounty.instance, 80, 3, true);

        // Duck
        EntityRegistry.registerModEntity(EntityDuck.class, "gaiasbounty.duck",
                DUCK_ID, GaiasBounty.instance, 80, 3, true);

        // Duck
        EntityRegistry.registerModEntity(EntityDeer.class, "gaiasbounty.deer",
                DEER_ID, GaiasBounty.instance, 80, 3, true);
    }

    public static void registerRenderers()
    {
        ClientTickHandler.init();

        // Bison
        RenderingRegistry.registerEntityRenderingHandler(EntityBison.class, new RenderBison(new ModelBison(), 0.5f));
        EntityRegistry.registerGlobalEntityID(EntityBison.class, "gaiasbounty.bison",
                EntityRegistry.findGlobalUniqueEntityId(), 0x221b14, 0x3f3024);

        // Turkey
        RenderingRegistry.registerEntityRenderingHandler(EntityTurkey.class, new RenderTurkey(new ModelTurkey(), 0.4f));
        EntityRegistry.registerGlobalEntityID(EntityTurkey.class, "gaiasbounty.turkey",
                EntityRegistry.findGlobalUniqueEntityId(), 0x38272a, 0x85819d);

        // Duck
        RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class, new RenderDuck(new ModelDuck(), 0.3f));
        EntityRegistry.registerGlobalEntityID(EntityDuck.class, "gaiasbounty.duck",
                EntityRegistry.findGlobalUniqueEntityId(), 0x795a43, 0xffa300);

        // Deer
        RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new RenderDeer(new ModelDeer(), 0.5f));
        EntityRegistry.registerGlobalEntityID(EntityDeer.class, "gaiasbounty.deer",
                EntityRegistry.findGlobalUniqueEntityId(), 0x8e612e, 0xffffff);
    }

    public static void registerEntitySpawn()
    {
        // Bison
        EntityRegistry.addSpawn(EntityBison.class, 8, 2, 6, EnumCreatureType.creature,
                getSpawnBiomes(BISON_ID));

        // Turkey
        EntityRegistry.addSpawn(EntityTurkey.class, 8, 4, 4, EnumCreatureType.creature,
                getSpawnBiomes(TURKEY_ID));

        // Duck
        EntityRegistry.addSpawn(EntityDuck.class, 12, 4, 4, EnumCreatureType.creature,
                getSpawnBiomes(DUCK_ID));

        // Deer
        EntityRegistry.addSpawn(EntityDeer.class, 8, 4, 4, EnumCreatureType.creature,
                getSpawnBiomes(DEER_ID));
    }

    private static BiomeGenBase[] getSpawnBiomes(int mobType)
    {
        ArrayList<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>(0);
        BiomeGenBase biomesList[] = BiomeGenBase.getBiomeGenArray();

        for (int i = 0; i < biomesList.length; i++)
        {
            if (biomesList[i] == null) continue;
            switch (mobType)
            {
                case BISON_ID:
                    if (BiomeDictionary.isBiomeOfType(biomesList[i], Type.PLAINS))
                        biomes.add(biomesList[i]);
                    break;
                case TURKEY_ID:
                    if (BiomeDictionary.isBiomeOfType(biomesList[i], Type.FOREST)
                            && !BiomeDictionary.isBiomeOfType(biomesList[i], Type.SAVANNA))
                        biomes.add(biomesList[i]);
                    break;
                case DUCK_ID:
                    if ((BiomeDictionary.isBiomeOfType(biomesList[i], Type.WET)
                            || BiomeDictionary.isBiomeOfType(biomesList[i], Type.RIVER))
                            && !BiomeDictionary.isBiomeOfType(biomesList[i], Type.SNOWY))
                        biomes.add(biomesList[i]);
                    break;
                case DEER_ID:
                    if (BiomeDictionary.isBiomeOfType(biomesList[i], Type.FOREST)
                            && !BiomeDictionary.isBiomeOfType(biomesList[i], Type.JUNGLE))
                        biomes.add(biomesList[i]);
            }
        }
        return biomes.toArray(new BiomeGenBase[0]);
    }
}
