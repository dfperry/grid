package dperry.game.grid.domain.tiles;

import dperry.game.grid.domain.Player;

public class HomeSystem extends Tile {

    Player player;

    public HomeSystem() {
        tileSafety = TileSafety.SAFE;
        tileType = TileType.HOME_SYSTEM;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
