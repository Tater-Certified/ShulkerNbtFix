package com.github.tatercertified.shulkernbtfix.mixin;

import com.github.tatercertified.shulkernbtfix.Config;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 1))
    private static Item.Settings redirectShulkerStackSize(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 2))
    private static Item.Settings redirectShulkerStackSize1(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 3))
    private static Item.Settings redirectShulkerStackSize2(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 4))
    private static Item.Settings redirectShulkerStackSize3(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 5))
    private static Item.Settings redirectShulkerStackSize4(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 6))
    private static Item.Settings redirectShulkerStackSize5(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 7))
    private static Item.Settings redirectShulkerStackSize6(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 8))
    private static Item.Settings redirectShulkerStackSize7(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 9))
    private static Item.Settings redirectShulkerStackSize8(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 10))
    private static Item.Settings redirectShulkerStackSize9(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 11))
    private static Item.Settings redirectShulkerStackSize10(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 12))
    private static Item.Settings redirectShulkerStackSize11(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 13))
    private static Item.Settings redirectShulkerStackSize12(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 14))
    private static Item.Settings redirectShulkerStackSize13(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 15))
    private static Item.Settings redirectShulkerStackSize14(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 16))
    private static Item.Settings redirectShulkerStackSize15(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 17))
    private static Item.Settings redirectShulkerStackSize16(Item.Settings instance, int maxCount) {
        return instance.maxCount(Config.stackSize);
    }
}
