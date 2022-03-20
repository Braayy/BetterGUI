package io.github.braayy.bettergui;

import io.github.braayy.bettergui.handler.GUISlotCleanClickHandler;
import io.github.braayy.bettergui.handler.GUISlotClickHandler;
import io.github.braayy.bettergui.handler.GUISlotPlaceableCleanClickHandler;
import io.github.braayy.bettergui.handler.GUISlotPlaceableClickHandler;
import io.github.braayy.bettergui.slot.GUISlot;
import io.github.braayy.bettergui.state.GUIState;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ExecutorService;

public abstract class StateGUI<G extends StateGUI<G, S>, S extends GUIState<G, S>> extends GUI {

    private S state;

    public StateGUI(S initialState) {
        this.state = initialState;
    }

    public StateGUI(S initialState, ExecutorService executorService) {
        super(executorService);
        this.state = initialState;
    }

    public S getState() {
        return state;
    }

    public void setState(S currentState, boolean simpleUpdate) {
        this.state = currentState;

        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(StateGUI.class);
        if (simpleUpdate)
            Bukkit.getScheduler().runTaskLater(plugin, this::simpleUpdate, 1L);
        else
            Bukkit.getScheduler().runTaskLater(plugin, this::fullUpdate, 1L);
    }

    @SuppressWarnings({"unchecked"})
    void stateSetup() {
        this.state.setup((G) this);
    }

    @Override
    public void setTitle(@NotNull String title) {
        super.setTitle(title);
    }

    @Override
    public @Nullable String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setSize(@NotNull GUISize size) {
        super.setSize(size);
    }

    @Override
    public GUISize getSize() {
        return super.getSize();
    }

    @Override
    public @Nullable GUI getParent() {
        return super.getParent();
    }

    @Override
    public void becomeSync() {
        super.becomeSync();
    }

    @Override
    public void addSlot(int slotNumber, GUISlot slot) {
        super.addSlot(slotNumber, slot);
    }

    @Override
    public void addButton(int slotNumber, @Nullable ItemStack icon, @NotNull GUISlotClickHandler handler) {
        super.addButton(slotNumber, icon, handler);
    }

    @Override
    public void addButton(int slotNumber, @Nullable ItemStack icon, @NotNull GUISlotCleanClickHandler handler) {
        super.addButton(slotNumber, icon, handler);
    }

    @Override
    public void addCapturable(int slotNumber, @NotNull ItemStack icon, @Nullable GUISlotClickHandler handler) {
        super.addCapturable(slotNumber, icon, handler);
    }

    @Override
    public void addCapturable(int slotNumber, @NotNull ItemStack icon, @Nullable GUISlotCleanClickHandler handler) {
        super.addCapturable(slotNumber, icon, handler);
    }

    @Override
    public void addCapturable(int slotNumber, @NotNull ItemStack icon) {
        super.addCapturable(slotNumber, icon);
    }

    @Override
    public void addDisplay(int slotNumber, @Nullable ItemStack item) {
        super.addDisplay(slotNumber, item);
    }

    @Override
    public void addPlaceable(int slotNumber, @Nullable GUISlotPlaceableClickHandler handler) {
        super.addPlaceable(slotNumber, handler);
    }

    @Override
    public void addPlaceable(int slotNumber, @Nullable GUISlotPlaceableCleanClickHandler handler) {
        super.addPlaceable(slotNumber, handler);
    }

    @Override
    public void addPlaceable(int slotNumber) {
        super.addPlaceable(slotNumber);
    }
}
