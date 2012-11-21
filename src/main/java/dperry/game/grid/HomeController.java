package dperry.game.grid;

import java.text.DateFormat;
import java.util.*;

import dperry.game.grid.domain.Grid;
import dperry.game.grid.domain.Player;
import dperry.game.grid.domain.User;
import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.config.GameDifficulty;
import dperry.game.grid.domain.config.GridSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    Grid normalGrid;
    Grid easyGrid;
    Grid hardGrid;

    List<Player> players;

    @PostConstruct
    public void init() {

        List<Player> players = new ArrayList<Player>();

        Player player1 = new Player();
        player1.setPlayerId(1);
        player1.setUser(new User("player1"));

        Player player2 = new Player();
        player2.setPlayerId(2);
        player2.setUser(new User("player2"));

        players.add(player1);
        players.add(player2);

        easyGrid = new Grid(new GameConfig(GridSize.MEDIUM, GameDifficulty.EASY), players);
        normalGrid = new Grid(new GameConfig(GridSize.MEDIUM, GameDifficulty.NORMAL), players);
        hardGrid = new Grid(new GameConfig(GridSize.MEDIUM, GameDifficulty.HARD), players);
    }

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    @RequestMapping("/testeasygrid")
    public ModelAndView testViewEasyGrid(ModelAndView model) {

        model.addObject("grid", easyGrid);

        model.setViewName("grid");
        return model;
    }

    @RequestMapping("/testnormalgrid")
    public ModelAndView testViewNormalGrid(ModelAndView model) {

        model.addObject("grid", normalGrid);

        model.setViewName("grid");
        return model;
    }

    @RequestMapping("/testhardgrid")
    public ModelAndView testViewHardGrid(ModelAndView model) {

        model.addObject("grid", hardGrid);

        model.setViewName("grid");
        return model;
    }

    @RequestMapping(value="/{grid}/{tile}/adjacent/{range}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Set<Integer> getAdjacentTiles(@PathVariable("grid") String gridName, @PathVariable("tile") Integer tile, @PathVariable("range") Integer range ) {
        if( gridName.equals("testhardgrid") ) {
            return hardGrid.getAdjacentTiles(tile, range);
        }
        else if( gridName.equals("testnormalgrid") ) {
            return normalGrid.getAdjacentTiles(tile, range);
        }
        else if( gridName.equals("testeasygrid") ) {
            return easyGrid.getAdjacentTiles(tile, range);
        }
        else {
            return null;
        }
    }
	
}
