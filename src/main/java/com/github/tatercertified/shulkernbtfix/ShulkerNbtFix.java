package com.github.tatercertified.shulkernbtfix;

import com.github.tatercertified.shulkernbtfix.recipe.ShapedShulkerBoxRecipe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeSerializer;

public class ShulkerNbtFix implements ModInitializer {
    public static final RecipeSerializer<ShapedShulkerBoxRecipe> SHULKER_BOX_NBT = RecipeSerializer.register("shulkernbtfix:crafting_shaped_shulker_box", new ShapedShulkerBoxRecipe.Serializer());

    @Override
    public void onInitialize() {
    }
}
