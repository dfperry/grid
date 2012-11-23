package dperry.game.grid.services;

import dperry.game.grid.domain.Game;
import dperry.game.grid.domain.config.GameStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {

    protected Map<Integer, Game> games;

    protected int lastId = 1;

    public GameService() {
        this.games = new HashMap<Integer, Game>();
    }

    public Game getGame(int gameId) {
        return games.get(gameId);
    }

    public Game addGame(Game game) {
        game.setGameId(++lastId);
        return games.put(lastId, game);
    }

    public List<Game> getUnstartedGames() {
        List<Game> unstartedGames = new ArrayList<Game>();

        for( Game game : games.values() ) {
            if( game.getGameStatus() == GameStatus.WAITING ) {
                unstartedGames.add(game);
            }
        }

        return unstartedGames;
    }
}
