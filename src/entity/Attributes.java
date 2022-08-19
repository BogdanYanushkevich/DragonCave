package entity;

public class Attributes extends Treasure{

    public Attributes(String name, int value, String descriptionOfTreasure) {
        super.setName(name);
        super.setValue(value);
        super.setDescriptionOfTreasure(descriptionOfTreasure);
    }


    @Override
    public String toString() {
        return String.format("%-15s %-30s Value: %-10d Description: %-150s", "Attributes:", super.getName(), super.getValue(),super.getDescriptionOfTreasure());
    }
}
