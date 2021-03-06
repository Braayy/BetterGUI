package io.github.braayy.bettergui.state;

import io.github.braayy.bettergui.StateGUI;
import org.bukkit.entity.Player;

public interface GUIState<G extends StateGUI<G, S>, S extends GUIState<G, S>> {

    void setup(G gui, Player player);

}
