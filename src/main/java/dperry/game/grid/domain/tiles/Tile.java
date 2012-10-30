package dperry.game.grid.domain.tiles;

public abstract class Tile {
    protected int index;

    protected TileSafety tileSafety;
    protected TileType tileType;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TileSafety getTileSafety() {
        return tileSafety;
    }

    public TileType getTileType() {
        return tileType;
    }
}
