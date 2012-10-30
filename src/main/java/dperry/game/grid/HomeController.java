package dperry.game.grid;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import dperry.game.grid.domain.Grid;
import dperry.game.grid.domain.config.GameConfig;
import dperry.game.grid.domain.config.GameDifficulty;
import dperry.game.grid.domain.config.GridSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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

        GameConfig config = new GameConfig(GridSize.MEDIUM, GameDifficulty.EASY);

        Grid grid = new Grid(config);
        model.addObject("grid", grid);

        model.setViewName("grid");
        return model;
    }

    @RequestMapping("/testnormalgrid")
    public ModelAndView testViewNormalGrid(ModelAndView model) {

        GameConfig config = new GameConfig(GridSize.MEDIUM, GameDifficulty.NORMAL);

        Grid grid = new Grid(config);
        model.addObject("grid", grid);

        model.setViewName("grid");
        return model;
    }

    @RequestMapping("/testhardgrid")
    public ModelAndView testViewHardGrid(ModelAndView model) {

        GameConfig config = new GameConfig(GridSize.MEDIUM, GameDifficulty.HARD);

        Grid grid = new Grid(config);
        model.addObject("grid", grid);

        model.setViewName("grid");
        return model;
    }
	
}
