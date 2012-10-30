package dperry.game.grid.domain.tiles;

public class GravityWell extends Tile {
    public GravityWell() {
        tileSafety = TileSafety.HAZARDOUS;
        tileType = TileType.GRAVITY_WELL;
    }
}
