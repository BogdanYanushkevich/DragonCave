package Menu;
import entity.Treasure;
import java.util.List;

public class ConsoleMenu {


    //Scanner sc = new Scanner(System.in);

    public void printMainPoints() {
        MenuLogic menuLogic = new MenuLogic();
        String menu = """

                Available Operations:\s
                1. Show all the treasures in the cave.
                2. Choose the most expensive treasure in the cave.
                3. Select treasures for a given amount.
                0. Exit.""";
        System.out.println(menu);
        selectionMainPoints(menuLogic.makeChoice(3, 0));
    }


    private void selectionMainPoints(int choice) {
        MenuLogic menuLogic = new MenuLogic();
        switch (choice) {
            case 1 -> {
                System.out.println("1. Show all the treasures in the cave.\n");
                menuLogic.showAllTreasure();
                printFirstMenu();
            }
            case 2 -> {
                System.out.println("2. Choose the most expensive treasure in the cave.\n");
                menuLogic.showTheMostExpensive();
                printSecondMenu();

            }
            case 3 -> {
                //Выбор на заданную сумму
                System.out.println("3. Select treasures for a given amount.\n");
                menuLogic.enterAmount();

            }
            case 0 -> System.out.println("0. Exit.\n");
        }
    }


    public void printFirstMenu() {
        MenuLogic menuLogic = new MenuLogic();
        String menu = """

                Available Operations:\s
                1. Select treasures for a given amount.
                2. Choose the most expensive treasure in the cave.
                0. Exit to previous menu.""";
        System.out.println(menu);
        selectionFirstMenu(menuLogic.makeChoice(2, 1));
    }


    private void selectionFirstMenu(int choice) {
        MenuLogic menuLogic = new MenuLogic();
        switch (choice) {
            case 1 -> {
                //Выбор на заданную сумму
                System.out.println("1. Select treasures for a given amount.\n");
                menuLogic.enterAmount();

            }
            case 2 -> {
                System.out.println("2. Choose the most expensive treasure in the cave.\n");
                menuLogic.showTheMostExpensive();
                printSecondMenu();

            }
            case 0 -> {
                System.out.println("0. Exit to previous menu.\n");
                printMainPoints();
            }
        }
    }


    public void printSecondMenu() {
        MenuLogic menuLogic = new MenuLogic();
        String menu = """

                Available Operations:\s
                1. Select treasures for a given amount.
                0. Exit to previous menu.""";
        System.out.println(menu);
        selectionSecondMenu(menuLogic.makeChoice(1, 2));

    }

    private void selectionSecondMenu(int choice) {
        MenuLogic menuLogic = new MenuLogic();
        switch (choice) {
            case 1 -> {
                //Выбор на заданную сумму
                System.out.println("1. Select treasures for a given amount.\n");
                menuLogic.enterAmount();
            }
            case 0 -> {
                System.out.println("0. Exit to previous menu.\n");
                printMainPoints();
            }
        }
    }

    public void printThirdMenu() {
        MenuLogic menuLogic = new MenuLogic();
        String menu = """

                Available Operations:\s
                1. Choose another treasure.
                2. Finish picking treasures.
                0. Exit.""";
        System.out.println(menu);
        selectionSecondMenu(menuLogic.makeChoice(1, 3));
    }

    public void printThirdMenu(int choiceSum, List<Treasure> treasures) {
        MenuLogic menuLogic = new MenuLogic();
        String menu = """

                Available Operations:\s
                1. Choose another treasure.
                2. Finish picking treasures.
                0. Exit.""";
        System.out.println(menu);
        selectionThirdMenu(menuLogic.makeChoice(2, 3), choiceSum, treasures);
    }


    private void selectionThirdMenu(int choice, int choiceSum, List<Treasure> treasures) {
        MenuLogic menuLogic = new MenuLogic();
        switch (choice) {
            case 1 -> {
                //Выбор на заданную сумму
                System.out.println("1. Choose another treasure.\n");
                menuLogic.formTreasures(choiceSum, treasures);
            }
            case 2 -> {
                System.out.println("2. Finish picking treasures.\n");
                //Метод заканчивающий выбор сокровищ и выводящий их список на экран
                menuLogic.endOfSelection(treasures);
            }
            case 0 -> {
                System.out.println("0. Exit to main menu.\n");
                //Метод заканчивающий выбор сокровищ и выводящий их список на экран
                printMainPoints();
            }
        }
    }
}




