package dperry.game.grid.domain.ships;

import dperry.game.grid.domain.Card;

public abstract class Ship extends Card {

    protected int cost;

    protected int shields;
    protected int range;
    protected int move;
    protected int attack;
    protected int capacity;

    protected int availablePoints;
    protected int usedPoints;


}
