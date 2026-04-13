package org.betterx.betterend.complexmaterials;

import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.tag.api.event.context.ItemTagBootstrapContext;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MaterialManager {
    private static List<Material> MATERIALS;

    public interface MaterialRecipe {
        void registerRecipes(RecipeOutput context);
    }

    public interface Material extends MaterialRecipe {
        void registerRecipes(RecipeOutput context);
        void registerBlockTags(TagBootstrapContext<Block> context);
        void registerItemTags(ItemTagBootstrapContext context);
    }

    public static void register(Material m) {
        if (ModCore.isDatagen()) {
            if (MATERIALS == null) MATERIALS = new ArrayList<>();
            MATERIALS.add(m);
        }
    }

    public static Stream<Material> stream() {
        if (MATERIALS == null) MATERIALS = new ArrayList<>();
        return MATERIALS.stream();
    }
}
