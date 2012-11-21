package dperry.game.grid.domain.tiles;

import dperry.game.grid.domain.Player;
import dperry.game.grid.domain.config.GameConfig;

import java.util.Map;
import java.util.Random;

public class TileFactory {
    protected GameConfig gameConfig;

    Random random = new Random(System.currentTimeMillis());

    public TileFactory(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Tile getHomeSystem(int index, Player player) {
        HomeSystem tile = new HomeSystem();
        tile.setPlayer(player);
        tile.setIndex(index);

        return tile;
    }

    public Tile getTile(int index) {
        Tile tile = null;
        if( random.nextFloat() <= gameConfig.getGameDifficulty().getHazard() ) {
            // it's a hazard tile
            // pick one
            if( random.nextBoolean() || random.nextBoolean() ) {
                tile = new AsteroidField();
            }
            else {
                tile = new GravityWell();
            }
        }
        else {
            // regular one;
            // empty space vs star system?
            if( random.nextFloat() <= gameConfig.getGameDifficulty().getEmpty() ) {
                tile = new EmptySpace();
            }
            else {
                tile = new StarSystem();
            }
        }

        if( tile != null ) {
            tile.setIndex(index);
        }

        return tile;
    }
}
