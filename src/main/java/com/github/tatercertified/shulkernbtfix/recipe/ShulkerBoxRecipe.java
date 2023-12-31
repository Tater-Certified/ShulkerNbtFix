package com.github.tatercertified.shulkernbtfix.recipe;

import com.github.tatercertified.shulkernbtfix.ShulkerNbtFix;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ShulkerBoxRecipe extends SpecialCraftingRecipe {

    public ShulkerBoxRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }


    @Override
    public boolean matches(CraftingInventory craftingInventory, World world) {
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
    public ItemStack craft(CraftingInventory craftingInventory, DynamicRegistryManager dynamicRegistryManager) {
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
    public boolean fits(int width, int height) {
        return width * height >= 3;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return super.getOutput(registryManager);
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
