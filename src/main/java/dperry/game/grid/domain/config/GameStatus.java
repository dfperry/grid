package dperry.game.grid.domain.config;

public enum GameStatus {
    WAITING("Waiting", "Waiting for game to begin"),
    STARTING("Starting", "Game is starting"),
    IN_PROGRESS("In-progress", "The game is currently in-progress"),
    COMPLETED("Completed", "A single player has been determined the winner");

    private String name;
    private String description;

    private GameStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
