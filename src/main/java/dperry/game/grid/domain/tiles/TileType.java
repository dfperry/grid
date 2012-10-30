package dperry.game.grid.domain.tiles;

public enum TileType {
    ASTEROID_FIELD("Asteroid Field"),
    EMPTY_SPACE("Empty Space"),
    GRAVITY_WELL("Gravity Well"),
    HOME_SYSTEM("Home System"),
    STAR_SYSTEM("Star System");

    protected String description;

    TileType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
