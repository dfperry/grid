package dperry.game.grid.domain;

import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.config.GameDifficulty;

import java.util.List;

public class Game {

    protected GameConfig gameConfig;
    protected GameDifficulty gameDifficulty;

    protected List<Player> players;

    protected Grid grid;

}
