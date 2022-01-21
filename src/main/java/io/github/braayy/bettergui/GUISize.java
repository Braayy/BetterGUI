package io.github.braayy.bettergui;

public enum GUISize {
    ONE_LINE(9),
    TWO_LINES(18),
    THREE_LINES(27),
    FOUR_LINES(36),
    FIVE_LINES(45),
    SIX_LINES(54);

    final int value;

    GUISize(int value) {
        this.value = value;
    }
}
