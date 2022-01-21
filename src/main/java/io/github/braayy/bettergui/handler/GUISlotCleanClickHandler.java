package io.github.braayy.bettergui.handler;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface GUISlotCleanClickHandler extends GUISlotClickHandler {

    @Override
    default void handle(InventoryClickEvent event) {
        handle();
    }

    void handle();
}
