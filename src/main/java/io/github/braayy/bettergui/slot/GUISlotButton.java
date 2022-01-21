package io.github.braayy.bettergui.slot;

import io.github.braayy.bettergui.handler.GUISlotCleanClickHandler;
import io.github.braayy.bettergui.handler.GUISlotClickHandler;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GUISlotButton implements GUISlot {

    @Nullable private final ItemStack icon;
    @NotNull private final GUISlotClickHandler handler;

    public GUISlotButton(@Nullable ItemStack icon, @NotNull GUISlotClickHandler handler) {
        this.icon = icon;
        this.handler = handler;
    }

    public GUISlotButton(@Nullable ItemStack icon, @NotNull GUISlotCleanClickHandler handler) {
        this.icon = icon;
        this.handler = handler;
    }

    @Nullable
    @Override
    public ItemStack getIcon() {
        return this.icon;
    }

    @NotNull
    public GUISlotClickHandler getHandler() {
        return this.handler;
    }
}
