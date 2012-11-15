package dperry.game.grid.domain;

import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.tiles.Tile;
import dperry.game.grid.domain.tiles.TileFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public List<Tile> getAdjacentTiles( Tile tile, int range ) {

        List<Tile> adjacentTiles = new ArrayList<Tile>();

        if( range > 0 ) {
            int id = tile.getIndex();

            boolean isOdd = (id/columns)%2 == 1;
            boolean isLeft = (id%columns == 0);
            boolean isRight = (id%columns == (columns-1));
            int modifier = (isOdd ? -1 : 0);

            if( !isRight ) adjacentTiles.add(getTile(id+1));
            if( !isLeft ) adjacentTiles.add(getTile(id-1));
            if( !(isLeft && isOdd) ) adjacentTiles.add(getTile(id-columns+modifier));
            if( !(isRight && !isOdd) ) adjacentTiles.add(getTile(id-columns+1+modifier));
            if( !(isLeft && isOdd) ) adjacentTiles.add(getTile(id+columns+modifier));
            if( !(isRight && !isOdd) ) adjacentTiles.add(getTile(id+columns+1+modifier));

            for( Tile innerTile : adjacentTiles ) {
                adjacentTiles.addAll(getAdjacentTiles(innerTile, range-1));
            }
        }

        return adjacentTiles;
    }

    public Set<Integer> getAdjacentTiles( int index, int range ) {
        Set<Integer> adjacentTiles = new TreeSet<Integer>();
        Set<Integer> tiles = new TreeSet<Integer>();
        if( range > 0 ) {
            int id = index;

            boolean isOdd = (id/columns)%2 == 1;
            boolean isLeft = (id%columns == 0);
            boolean isRight = (id%columns == (columns-1));
            int modifier = (isOdd ? -1 : 0);

            if( !isRight ) tiles.add(id+1);
            if( !isLeft ) tiles.add(id-1);
            if( !(isLeft && isOdd) ) tiles.add(id-columns+modifier);
            if( !(isRight && !isOdd) ) tiles.add(id-columns+1+modifier);
            if( !(isLeft && isOdd) ) tiles.add(id+columns+modifier);
            if( !(isRight && !isOdd) ) tiles.add(id+columns+1+modifier);

            for( Integer innerTile : tiles ) {
                adjacentTiles.add(innerTile);
                adjacentTiles.addAll(getAdjacentTiles(new Integer(innerTile), range-1));
            }
        }

        return adjacentTiles;
    }
}
