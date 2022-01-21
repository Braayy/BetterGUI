package io.github.braayy.bettergui;

import io.github.braayy.bettergui.slot.GUISlot;
import org.jetbrains.annotations.Range;

import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class PaginatedGUI extends GUI {
    private int currentPage, slotsPerPage;
    private List<GUISlot> slots;

    public PaginatedGUI() {}

    public PaginatedGUI(ExecutorService executorService) {
        super(executorService);
    }

    protected void setSlots(List<GUISlot> slots) {
        this.slots = slots;
    }

    protected boolean isEmpty() {
        return slots == null || slots.isEmpty();
    }

    protected void setSlotsPerPage(@Range(from = ONE_LINE, to = FOUR_LINES) int slotsPerPage) {
        if (slotsPerPage < 9 || slotsPerPage > 36 || slotsPerPage % 9 != 0) throw new IllegalArgumentException("Invalid slots per page value: " + slotsPerPage);

        this.slotsPerPage = slotsPerPage;
    }

    protected int getCurrentPage() {
        return currentPage;
    }

    protected int getMaxPage() {
        if (slots == null || slotsPerPage == 0) return 0;

        return slots.size() / slotsPerPage;
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

    protected void pageSetup() {
        int startIndex = currentPage * slotsPerPage;
        int endIndex = Math.min(currentPage * slotsPerPage + slotsPerPage, slots.size());

        List<? extends GUISlot> slotsView = slots.subList(startIndex, endIndex);
        int slot = 9;
        for (GUISlot guiSlot : slotsView) {
            addSlot(slot++, guiSlot);
        }
    }
}
