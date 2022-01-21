package io.github.braayy.bettergui.slot;

import io.github.braayy.bettergui.handler.GUISlotClickHandler;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GUISlotCapturable implements GUISlot {

    @NotNull private final ItemStack item;
    @Nullable private final GUISlotClickHandler handler;

    public GUISlotCapturable(@NotNull ItemStack item, @Nullable GUISlotClickHandler handler) {
        this.item = item;
        this.handler = handler;
    }

    @NotNull
    @Override
    public ItemStack getIcon() {
        return this.item;
    }

    @Nullable
    public GUISlotClickHandler getHandler() {
        return this.handler;
    }
}
