package Menu;

import entity.Treasure;
import main.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuLogic {


    public void showAllTreasure() {
        Main.dragonCave.getTreasures().forEach(System.out::println);
    }


    public void showTheMostExpensive() {

        int max = 0;
        int indexOfMostExpensive = 0;


        for (Treasure tr : Main.dragonCave.getTreasures()) {

            if (tr.getValue() > max) {
                max = tr.getValue();
                indexOfMostExpensive = Main.dragonCave.getTreasures().indexOf(tr);
            }
        }

        System.out.println(Main.dragonCave.getTreasures().get(indexOfMostExpensive));
    }


    //Реализация третьего пункта.

    public void rollList(List<Treasure> treasures) {

        for (Treasure tr : treasures) {
            System.out.println(treasures.indexOf(tr) + 1 + ": " + tr);
        }
    }

    public boolean checkGold(int money, int purchaseAmount) {
        return money >= purchaseAmount;
    }

    public void formTreasures(int choiceSum, List<Treasure>chosenTreasure) {

        List<Treasure> treasures = Main.dragonCave.getTreasures();

        rollList(treasures);

        System.out.println("\n\nYou can choose a treasure worth: " + choiceSum);
        System.out.println("\nEnter the number of the selected treasure");
        System.out.println("\n\n0: Finish picking treasures.");

        chosenTreasure(treasures, choiceSum, chosenTreasure);

    }


    public void chosenTreasure(List<Treasure> treasures, int choiceSum, List<Treasure>chosenTreasure) {

        ConsoleMenu cs = new ConsoleMenu();

        Scanner sc = new Scanner(System.in);

        int choice;


        try {
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                endOfSelection(chosenTreasure);

            } else if (choice > treasures.size() || choice < 0) {
                System.out.println("It is not possible to make a choice for this number. Try again.\n");
                formTreasures(choiceSum, chosenTreasure);
            } else if (checkGold(choiceSum, treasures.get(choice - 1).getValue())) {
                //Метод формирующий список сокровищ с индексами.

                chosenTreasure.add(treasures.get(choice - 1));
                choiceSum = choiceSum - treasures.get(choice - 1).getValue();
                System.out.println("Item added successfully.\n" + treasures.get(choice - 1) + "\n\n");
                treasures.remove(choice - 1);
                formTreasures(choiceSum, chosenTreasure);

            } else {
                System.out.println("You do not have enough money to select this item.");
                cs.printThirdMenu(choiceSum, chosenTreasure);
                cs.printThirdMenu(choiceSum ,chosenTreasure);



            }


        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Repeat entry");
            formTreasures(choiceSum, chosenTreasure);
        }

    }


    public int sumOfTreasure() {
        return Main.dragonCave.getTreasures().stream().mapToInt(Treasure::getValue).sum();
    }


    public void enterAmount() {
        List<Treasure> chosenTreasures = new ArrayList<>();
        ConsoleMenu cs = new ConsoleMenu();
        Scanner sc = new Scanner(System.in);

        int amount;


        System.out.println("The cave contains treasures totaling :" + sumOfTreasure() + "\n" +
                "The maximum amount you can take treasure is: " + sumOfTreasure() +
                "\nEnter the desired amount." +
                "\n\n\n0: Exit to main menu:");


        try {
            amount = Integer.parseInt(sc.nextLine());

            if (amount == 0) {
                cs.printMainPoints();
                return;
            }
            if (amount > sumOfTreasure() || amount < 0) {
                System.out.println("It is not possible to make a choice for this amount. Try again.");
                enterAmount();
            } else {
                //Метод формирующий список сокровищ с индексами.
                formTreasures(amount, chosenTreasures);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Repeat entry");
            enterAmount();
        }

    }


    public void endOfSelection(List<Treasure>treasures) {
        ConsoleMenu cs = new ConsoleMenu();
        treasures.forEach(System.out::println);
        System.out.println("Congratulations, you are now the owner of these treasures.");
        cs.printMainPoints();
        }



    //Реализация третьего пункта конец.


    public int makeChoice(int fork, int menuNam) {
        Scanner sc = new Scanner(System.in);
        ConsoleMenu cs = new ConsoleMenu();
        int choice;

        try {
            choice = Integer.parseInt(sc.nextLine());

            if (choice > fork || choice < 0) {
                System.out.println("Not an existing option to select. Try again.");

                switch (menuNam) {
                    case 0:
                        cs.printMainPoints();
                    case 1:
                        cs.printFirstMenu();
                    case 2:
                        cs.printSecondMenu();
                    case 3:
                        cs.printThirdMenu();


                }
            } else {
                return choice;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Repeat entry");
            switch (menuNam) {
                case 0:
                    cs.printMainPoints();
                case 1:
                    cs.printFirstMenu();
                case 2:
                    cs.printSecondMenu();
                case 3:
                    cs.printThirdMenu();

            }

        }
        return -1;
    }
}





