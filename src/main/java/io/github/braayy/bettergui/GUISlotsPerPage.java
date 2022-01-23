package io.github.braayy.bettergui;

public enum GUISlotsPerPage {
    ONE_LINE(9),
    TWO_LINES(18),
    THREE_LINES(27),
    FOUR_LINES(36);

    public final int value;

    GUISlotsPerPage(int value) {
        this.value = value;
    }
}
