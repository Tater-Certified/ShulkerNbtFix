package com.github.tatercertified.shulkernbtfix.mixin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(ShapedRecipe.class)
public interface ShapedRecipeInvoker {
    @Invoker("readSymbols")
    public static Map<String, Ingredient> readSymbols(JsonObject json) {
        throw new AssertionError();
    }

    @Invoker("removePadding")
    public static String[] removePadding(String... pattern) {
        throw new AssertionError();
    }

    @Invoker("getPattern")
    public static String[] getPattern(JsonArray json) {
        throw new AssertionError();
    }

    @Invoker("createPatternMatrix")
    public static DefaultedList<Ingredient> createPatternMatrix(String[] pattern, Map<String, Ingredient> symbols, int width, int height) {
        throw new AssertionError();
    }

    @Accessor
    DefaultedList<Ingredient> getInput();

    @Accessor
    ItemStack getOutput();

    @Accessor
    boolean getShowNotification();
}
