package dperry.game.grid.domain;

public class PlayerAction {
    protected int tileId;
    protected int playerId;
    protected ActionType actionType;


    public enum ActionType {
        MOVE,
        ATTACK,
        BUILD,
        TRANSPORT
    }
}
