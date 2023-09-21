package com.github.tatercertified.shulkernbtfix.recipe;

import com.github.tatercertified.shulkernbtfix.ShulkerNbtFix;
import eu.pb4.polymer.core.api.item.PolymerRecipe;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ShulkerBoxRecipe extends SpecialCraftingRecipe implements PolymerRecipe {

    public ShulkerBoxRecipe(CraftingRecipeCategory category) {
        super(category);

    }

    @Override
    public boolean matches(RecipeInputInventory craftingInventory, World world) {
        for (int i = 0; i < 3; i++) {
            ItemStack stack = craftingInventory.getStack(i);
            if (!stack.isEmpty() && stack.getItem() == Items.SHULKER_SHELL) {
                i = i + 3;
                stack = craftingInventory.getStack(i);
                if (!stack.isEmpty() && stack.getItem() == Items.CHEST) {
                    i = i + 3;
                    stack = craftingInventory.getStack(i);
                    if (!stack.isEmpty() && stack.getItem() == Items.SHULKER_SHELL) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack output = new ItemStack(Items.SHULKER_BOX);
        NbtCompound compound = output.getOrCreateNbt();
        NbtCompound block_entity_compound = new NbtCompound();
        NbtList items = new NbtList();

        block_entity_compound.put("Items", items);
        block_entity_compound.putString("id", "minecraft:shulker_box");
        compound.put("BlockEntityTag", block_entity_compound);
        return output;
    }

    @Override
    public @Nullable Recipe<?> getPolymerReplacement(ServerPlayerEntity player) {
        return PolymerRecipe.createCraftingRecipe(this);
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 3;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ShulkerNbtFix.SHULKER_BOX_NBT;
    }


}
