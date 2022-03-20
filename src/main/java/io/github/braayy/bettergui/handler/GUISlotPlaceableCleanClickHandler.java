package io.github.braayy.bettergui.handler;

import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface GUISlotPlaceableCleanClickHandler extends GUISlotPlaceableClickHandler {

    @Override
    default void handle(ItemStack stack) {
        handle();
    }

    void handle();

}
