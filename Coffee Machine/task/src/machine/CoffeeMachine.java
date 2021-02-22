package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        ThreeTypeCM newMachine = new ThreeTypeCM();
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            newMachine.administration(choice);
            if (choice.equals("exit")) {
                scanner.close();
                break;
            }
        }
    }

}

 class ThreeTypeCM {

    static int totalWater = 400;
    static int totalMilk = 540;
    static int totalBeans = 120;
    static int totalCups = 9;
    static int value = 550;

    public void administration(String action) {
        switch (action) {
            case "buy" :
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                Scanner buyScan = new Scanner(System.in);
                String buyChoice = buyScan.nextLine();
                if (buyChoice.equals("back")) {
                    break;
                }
                chooseCoffee(buyChoice);
                break;
            case "fill" :
                Scanner fillScan = new Scanner(System.in);
                System.out.println("\nWrite how many ml of water do you want to add:");
                totalWater += fillScan.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                totalMilk += fillScan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                totalBeans += fillScan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                totalCups += fillScan.nextInt();
                break;
            case "take" :
                System.out.printf("\nI gave you $%d\n", value);
                value = 0;
                break;
            case "remaining":
                statusMachine();
                break;
            default:
                break;
        }
    }
    public void chooseCoffee(String choice) {
            int ch = Integer.parseInt(choice);
            switch (ch) {
                case 1:
                    if (totalWater >= 250 && totalBeans >= 16 && totalCups >= 1) {
                        totalWater -= 250;
                        totalBeans -= 16;
                        totalCups--;
                        value += 4;
                        System.out.println("I have enough resources, making you a coffee!");
                    } else {
                        if (totalWater < 250) {
                            System.out.println("Sorry, not enough water!");
                        }
                        if (totalBeans < 16) {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        if (totalCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                    break;
                case 2:
                    if (totalWater >= 350 && totalBeans >= 20 && totalCups >= 1 && totalMilk >= 75) {
                        totalWater -= 350;
                        totalMilk -= 75;
                        totalBeans -= 20;
                        totalCups--;
                        value += 7;
                        System.out.println("I have enough resources, making you a coffee!");
                    } else {
                        if (totalWater < 350) {
                            System.out.println("Sorry, not enough water!");
                        }
                        if (totalBeans < 20) {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        if (totalCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        if (totalMilk < 75) {
                            System.out.println("Sorry, not enough milk!");
                        }
                    }
                    break;
                case 3:
                    if (totalWater >= 200 && totalBeans >= 12 && totalCups >= 1 && totalMilk >= 100) {
                        totalWater -= 200;
                        totalMilk -= 100;
                        totalBeans -= 12;
                        totalCups--;
                        value += 6;
                        System.out.println("I have enough resources, making you a coffee!");
                    } else {
                        if (totalWater < 200) {
                            System.out.println("Sorry, not enough water!");
                        }
                        if (totalBeans < 12) {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        if (totalCups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        if (totalMilk < 100) {
                            System.out.println("Sorry, not enough milk!");
                        }
                    }
                    break;
                default:
                    break;
            }
    }
    public void statusMachine() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "$%d of money\n", totalWater, totalMilk, totalBeans, totalCups, value);
    }
}
