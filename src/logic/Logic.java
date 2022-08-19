package logic;

import entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {


    public List<Treasure> fillTheCave(int numOfTreasure) {

        List<Treasure> treasures = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Bogdan\\IdeaProjects\\Basics_of_OOP\\src\\by\\epam\\module_5\\basics_of_oop\\task_4\\data/treasurelist.txt");
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNextLine() && numOfTreasure-- > 0) {
                String[] treasureLine = sc.nextLine().split(" - ");
                String treasureType = treasureLine[0];
                String treasureName = treasureLine[1];
                int treasureValue = Integer.parseInt(treasureLine[2]);
                String treasureDescription = treasureLine[3];
                switch (treasureType) {
                    case "Accessories" ->
                            treasures.add(new Accessories(treasureName, treasureValue, treasureDescription));
                    case "Armor" -> treasures.add(new Armor(treasureName, treasureValue, treasureDescription));
                    case "Attributes" ->
                            treasures.add(new Attributes(treasureName, treasureValue, treasureDescription));
                    case "Consumables" ->
                            treasures.add(new Consumables(treasureName, treasureValue, treasureDescription));
                    case "Magical" -> treasures.add(new Magical(treasureName, treasureValue, treasureDescription));
                    case "Weapon" -> treasures.add(new Weapon(treasureName, treasureValue, treasureDescription));
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Treasure information file not found.");
        }
        return treasures;
    }



}
