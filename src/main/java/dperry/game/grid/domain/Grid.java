package dperry.game.grid.domain;

import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.tiles.Tile;
import dperry.game.grid.domain.tiles.TileFactory;

import java.util.ArrayList;

public class Grid {

    protected int rows;
    protected int columns;
    protected ArrayList<Tile> tiles;

    TileFactory tileFactory;

    public Grid(GameConfig config) {
        this.rows = config.getGridSize().getRows();
        this.columns = config.getGridSize().getColumns();

        tiles = new ArrayList<Tile>();

        tileFactory = new TileFactory(config);

        for( int i = 0; i < rows*columns; i++) {
            tiles.add(tileFactory.getTile(i));
        }
    }

    public Tile getTile(int index) {
        return tiles.get(index);
    }

    public void setTile(int index, Tile tile) {
        tiles.set(index, tile);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
