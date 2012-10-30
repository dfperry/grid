package dperry.game.grid.domain.config;

public enum GameDifficulty {
    EASY(1, 0.05f, 0.25f, "Easy", "Few hazards, more benefits"),
    NORMAL(2, 0.15f, 0.35f, "Normal", "Moderate number of hazards, benefits"),
    HARD(3, 0.30f, 0.45f, "Hard", "More hazards, fewer benefits");

    protected int rank;
    protected float hazard;
    protected float empty;
    protected String name;
    protected String description;

    GameDifficulty(int rank, float hazard, float empty, String name, String description) {
        this.rank = rank;
        this.hazard = hazard;
        this.empty = empty;
        this.name = name;
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public float getHazard() {
        return hazard;
    }

    public float getEmpty() {
        return empty;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
