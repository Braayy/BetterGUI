package io.github.braayy.bettergui.slot;

import io.github.braayy.bettergui.handler.GUISlotPlaceableClickHandler;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.Nullable;

public class GUISlotPlaceable implements GUISlot {

    @Nullable private final GUISlotPlaceableClickHandler handler;

    public GUISlotPlaceable(@Nullable GUISlotPlaceableClickHandler handler) {
        this.handler = handler;
    }

    @Nullable
    @Override
    public ItemStack getIcon() {
        return null;
    }

    @Nullable
    public GUISlotPlaceableClickHandler getHandler() {
        return this.handler;
    }
}
