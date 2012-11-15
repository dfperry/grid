package dperry.game.grid.domain.tiles;

import dperry.game.grid.domain.Player;

import java.util.List;

public abstract class Tile {
    protected int index;

    protected TileSafety tileSafety;
    protected TileType tileType;

    protected List<Player> known;

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

    public void addPlayer( Player player ) {
        known.add(player);
    }

    public void removePlayer( Player player ) {
        known.remove(player);
    }
}
