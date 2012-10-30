package dperry.game.grid.domain.tiles;

public class EmptySpace extends Tile {
    public EmptySpace() {
        tileSafety = TileSafety.SAFE;
        tileType = TileType.EMPTY_SPACE;
    }
}
