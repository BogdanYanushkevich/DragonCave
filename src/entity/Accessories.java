package entity;

public class Accessories extends Treasure{
    public Accessories(String name, int value, String descriptionOfTreasure) {
        super.setName(name);
        super.setValue(value);
        super.setDescriptionOfTreasure(descriptionOfTreasure);
    }


    @Override
    public String toString() {
        return String.format("%-15s %-30s Value: %-10d Description: %-50s", "Accessories:", super.getName(), super.getValue(),super.getDescriptionOfTreasure());
    }
}
