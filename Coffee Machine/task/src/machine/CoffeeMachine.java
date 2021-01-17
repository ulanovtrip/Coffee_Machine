package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    showState();
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
    }

    public static boolean analiseResources() {
        if (water < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    public static void buy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String varietyOfCoffee = scanner.nextLine();
        switch (varietyOfCoffee) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
        }
    }

    public static void fill() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    public static void take() {
        System.out.println();
        System.out.printf("I gave you $%d\n", money);
        money = 0;
        System.out.println();
    }

    public static void cappuccino() {
        water -= 200;
        milk -= 100;
        beans -= 12;
        money += 6;
        cups -= 1;
        if (!analiseResources()) {
            water += 200;
            milk += 100;
            beans += 12;
            money -= 6;
            cups += 1;
        }
    }

    public static void espresso() {
        water -= 250;
        beans -= 16;
        money += 4;
        cups -= 1;
        if (!analiseResources()) {
            water += 250;
            beans += 16;
            money -= 4;
            cups += 1;
        }
    }

    public static void latte() {
        water -= 350;
        milk -= 75;
        beans -= 20;
        money += 7;
        cups -= 1;
        if (!analiseResources()) {
            water += 350;
            milk += 75;
            beans += 20;
            money -= 7;
            cups += 1;
        }
    }

    public static void showState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", beans);
        System.out.printf("%d of disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
    }
}
