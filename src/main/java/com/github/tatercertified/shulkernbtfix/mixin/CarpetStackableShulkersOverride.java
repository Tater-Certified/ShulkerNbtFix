package com.github.tatercertified.shulkernbtfix.mixin;

import carpet.helpers.InventoryHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InventoryHelper.class)
public class CarpetStackableShulkersOverride {
    /**
     * @author QPCrummer
     * @reason This method is useless as my mod makes sure that all shulker boxes have the necessary tags when crafted
     */
    @Overwrite
    public static boolean cleanUpShulkerBoxTag(ItemStack stack) {
        return true;
    }
}
