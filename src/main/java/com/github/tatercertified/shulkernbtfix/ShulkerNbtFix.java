package com.github.tatercertified.shulkernbtfix;

import com.github.tatercertified.shulkernbtfix.recipe.ShulkerBoxRecipe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;

public class ShulkerNbtFix implements ModInitializer {

    public static RecipeSerializer<ShulkerBoxRecipe> SHULKER_BOX_NBT = RecipeSerializer.register("crafting_shaped_shulker_box", new SpecialRecipeSerializer<>(ShulkerBoxRecipe::new));



    @Override
    public void onInitialize() {
    }
}
