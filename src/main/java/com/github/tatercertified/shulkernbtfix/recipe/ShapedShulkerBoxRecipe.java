package com.github.tatercertified.shulkernbtfix.recipe;

import com.github.tatercertified.shulkernbtfix.ShulkerNbtFix;
import com.github.tatercertified.shulkernbtfix.mixin.ShapedRecipeInvoker;
import com.google.gson.JsonObject;
import eu.pb4.polymer.core.api.item.PolymerRecipe;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ShapedShulkerBoxRecipe extends ShapedRecipe implements PolymerRecipe {
    public ShapedShulkerBoxRecipe(Identifier id, String group, CraftingRecipeCategory category, int width, int height, DefaultedList<Ingredient> input, ItemStack output, boolean showNotification) {
        super(id, group, category, width, height, input, output, showNotification);
    }

    @Override
    public @Nullable Recipe<?> getPolymerReplacement(ServerPlayerEntity player) {
        return PolymerRecipe.createCraftingRecipe(this);
    }

    @Override
    public ItemStack craft(RecipeInputInventory recipeInputInventory, DynamicRegistryManager dynamicRegistryManager) {
        ItemStack output = this.getOutput(dynamicRegistryManager).copy();
        NbtCompound compound = output.getOrCreateNbt();
        NbtCompound block_entity_compound = new NbtCompound();
        NbtList items = new NbtList();

        block_entity_compound.put("Items", items);
        block_entity_compound.putString("id", "minecraft:shulker_box");
        compound.put("BlockEntityTag", block_entity_compound);
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ShulkerNbtFix.SHULKER_BOX_NBT;
    }

    /**
     * This is Mojang's code, but I couldn't figure out how change it without doing this
     */
    public static class Serializer implements RecipeSerializer<ShapedShulkerBoxRecipe> {
        public Serializer() {
        }

        public ShapedShulkerBoxRecipe read(Identifier identifier, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            CraftingRecipeCategory craftingRecipeCategory = CraftingRecipeCategory.CODEC.byId(JsonHelper.getString(jsonObject, "category", null), CraftingRecipeCategory.MISC);
            Map<String, Ingredient> map = ShapedRecipeInvoker.readSymbols(JsonHelper.getObject(jsonObject, "key"));
            String[] strings = ShapedRecipeInvoker.removePadding(ShapedRecipeInvoker.getPattern(JsonHelper.getArray(jsonObject, "pattern")));
            int i = strings[0].length();
            int j = strings.length;
            DefaultedList<Ingredient> defaultedList = ShapedRecipeInvoker.createPatternMatrix(strings, map, i, j);
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            boolean bl = JsonHelper.getBoolean(jsonObject, "show_notification", true);
            return new ShapedShulkerBoxRecipe(identifier, string, craftingRecipeCategory, i, j, defaultedList, itemStack, bl);
        }

        public ShapedShulkerBoxRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            int i = packetByteBuf.readVarInt();
            int j = packetByteBuf.readVarInt();
            String string = packetByteBuf.readString();
            CraftingRecipeCategory craftingRecipeCategory = packetByteBuf.readEnumConstant(CraftingRecipeCategory.class);
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);

            for(int k = 0; k < defaultedList.size(); ++k) {
                defaultedList.set(k, Ingredient.fromPacket(packetByteBuf));
            }

            ItemStack itemStack = packetByteBuf.readItemStack();
            boolean bl = packetByteBuf.readBoolean();
            return new ShapedShulkerBoxRecipe(identifier, string, craftingRecipeCategory, i, j, defaultedList, itemStack, bl);
        }

        public void write(PacketByteBuf packetByteBuf, ShapedShulkerBoxRecipe shapedRecipe) {
            packetByteBuf.writeVarInt(shapedRecipe.getWidth());
            packetByteBuf.writeVarInt(shapedRecipe.getHeight());
            packetByteBuf.writeString(shapedRecipe.getGroup());
            packetByteBuf.writeEnumConstant(shapedRecipe.getCategory());

            for (Ingredient ingredient : ((ShapedRecipeInvoker)shapedRecipe).getInput()) {
                ingredient.write(packetByteBuf);
            }

            packetByteBuf.writeItemStack(((ShapedRecipeInvoker)shapedRecipe).getOutput());
            packetByteBuf.writeBoolean(((ShapedRecipeInvoker)shapedRecipe).getShowNotification());
        }
    }
}
