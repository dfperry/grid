package dperry.game.grid.domain.tiles;

public class AsteroidField extends Tile {

    public AsteroidField() {
        tileSafety = TileSafety.HAZARDOUS;
        tileType = TileType.ASTEROID_FIELD;
    }
}
