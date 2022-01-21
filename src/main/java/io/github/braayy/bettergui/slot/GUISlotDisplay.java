package io.github.braayy.bettergui.slot;

import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.Nullable;

public class GUISlotDisplay implements GUISlot {
    @Nullable
    private final ItemStack item;

    public GUISlotDisplay(@Nullable ItemStack item) {
        this.item = item;
    }

    @Nullable
    @Override
    public ItemStack getIcon() {
        return this.item;
    }
}
