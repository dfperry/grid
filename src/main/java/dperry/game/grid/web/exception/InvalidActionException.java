package dperry.game.grid.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Invalid action")
public class InvalidActionException extends Exception {

    public InvalidActionException(String message) {
        super(message);
    }
}
