package io.github.braayy.bettergui;

import io.github.braayy.bettergui.slot.GUISlot;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public abstract class PaginatedGUI extends GUI {
    private int currentPage;
    private GUISlotsPerPage slotsPerPage;
    private List<GUISlot> slots;

    public PaginatedGUI() {}

    public PaginatedGUI(ExecutorService executorService) {
        super(executorService);
    }

    protected void setSlots(List<GUISlot> slots) {
        this.slots = slots;
    }

    protected boolean isSlotsLoaded() {
        return slots != null;
    }

    protected List<GUISlot> getSlots() {
        return slots;
    }

    protected void setSlotsPerPage(@NotNull GUISlotsPerPage slotsPerPage) {
        Objects.requireNonNull(slotsPerPage, "slots per page cannot be null");

        this.slotsPerPage = slotsPerPage;
    }

    protected int getCurrentPage() {
        return currentPage;
    }

    protected int getMaxPage() {
        if (slots == null || slotsPerPage == null) return 0;

        return slots.size() / slotsPerPage.value;
    }

    protected void nextPage(boolean updateTitle) {
        if (this.currentPage == getMaxPage()) return;
        this.currentPage += 1;

        if (updateTitle)
            fullUpdate();
        else
            simpleUpdate();
    }

    protected void previousPage(boolean updateTitle) {
        if (this.currentPage == 0) return;
        this.currentPage -= 1;

        if (updateTitle)
            fullUpdate();
        else
            simpleUpdate();
    }

    void pageSetup() {
        int startIndex = currentPage * slotsPerPage.value;
        int endIndex = Math.min(currentPage * slotsPerPage.value + slotsPerPage.value, slots.size());

        List<? extends GUISlot> slotsView = slots.subList(startIndex, endIndex);
        int slot = 9;
        for (GUISlot guiSlot : slotsView) {
            addSlot(slot++, guiSlot);
        }
    }
}
