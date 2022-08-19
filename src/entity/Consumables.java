package entity;

public class Consumables extends Treasure{

    public Consumables(String name, int value, String descriptionOfTreasure) {
        super.setName(name);
        super.setValue(value);
        super.setDescriptionOfTreasure(descriptionOfTreasure);
    }


    @Override
    public String toString() {
        return String.format("%-15s %-30s Value: %-10d Description: %-150s", "Consumables:", super.getName(), super.getValue(),super.getDescriptionOfTreasure());
    }
}

