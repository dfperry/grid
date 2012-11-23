package dperry.game.grid.web.controllers;

import dperry.game.grid.domain.PlayerAction;
import dperry.game.grid.services.GameService;
import dperry.game.grid.web.exception.InvalidActionException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value="/game/new")
    public ModelAndView createNewGame(ModelAndView model) {

        return model;
    }

    @RequestMapping(value="/game/{id}")
    public ModelAndView viewGame(ModelAndView model, @PathVariable("id") int gameId) {

        model.addObject("game", gameService.getGame(gameId));
        return model;
    }

    public ModelAndView joinGame(ModelAndView model) {

        return model;
    }

    @RequestMapping(value="/game/{id}/action", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAction(ModelAndView model, @PathVariable("id") int gameId, @RequestParam("action") String actionString ) throws InvalidActionException {
        PlayerAction action;

        try {
            action = objectMapper.readValue(actionString, PlayerAction.class);
        }
        catch( JsonParseException e ) {

        }
        catch( JsonMappingException e ) {

        }
        catch( IOException e ) {

        }
    }
}
