package entity;

import logic.Logic;

import java.util.List;

public class Cave {

    private List<Treasure> treasures;

    private int numOfTreasures;

    private final Logic logic = new Logic();

    public void addTreasure(Treasure t) {
        treasures.add(t);
    }

    public List<Treasure> getTreasures() {

        return treasures;
    }

    public int getNumOfTreasures() {
        return numOfTreasures;
    }

    public void fillTheDragonCave(int numOfTreasures){
        this.treasures = logic.fillTheCave(numOfTreasures);
        this.numOfTreasures = numOfTreasures;
    }
}
