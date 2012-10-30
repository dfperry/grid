package dperry.game.grid.domain.config;

public class GameConfig {

    protected GridSize gridSize;
    protected GameDifficulty gameDifficulty;

    public GameConfig(GridSize gridSize, GameDifficulty gameDifficulty) {
        this.gridSize = gridSize;
        this.gameDifficulty = gameDifficulty;
    }

    public GridSize getGridSize() {
        return gridSize;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }
}
