package dperry.game.grid.domain.tiles;

public enum TileSafety {
    SAFE("Safe"),
    HAZARDOUS("Hazardous");

    protected String description;

    TileSafety(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
