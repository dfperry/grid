package dperry.game.grid.domain;

import dperry.game.grid.domain.config.GameConfig;

import java.util.List;

public class ActiveGame {
    protected List<Player> players;
    protected Grid grid;
    protected int rounds;
    protected Player activePlayer;

    protected GameConfig gameConfig;

    protected Grid buildGrid() {
        return grid = new Grid(gameConfig);
    }
}
