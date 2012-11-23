package dperry.game.grid.domain;

import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.config.GameDifficulty;
import dperry.game.grid.domain.config.GameStatus;

import java.util.List;

public class Game {

    protected int gameId = -1;
    protected GameConfig gameConfig;
    protected GameDifficulty gameDifficulty;

    protected GameStatus gameStatus;

    protected List<Player> players;

    protected Grid grid;

    public Game() {
        this.gameStatus = GameStatus.WAITING;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
