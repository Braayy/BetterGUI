package io.github.braayy.bettergui.handler;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface GUISlotClickHandler {

    void handle(InventoryClickEvent event);

}
