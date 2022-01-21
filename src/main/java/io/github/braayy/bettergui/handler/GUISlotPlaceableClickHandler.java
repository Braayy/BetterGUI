package io.github.braayy.bettergui.handler;

import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface GUISlotPlaceableClickHandler {

    void handle(ItemStack item);

}
