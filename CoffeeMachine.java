package machine;

import java.util.Objects;
import java.util.Scanner;
public class CoffeeMachine
{
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disCups = 9;
    static int money = 550;
    static String action;
    static Scanner scanner = new Scanner(System.in);


    // Espresso = 250 ml water , 0 ml milk , 16 g coffee beans , cost 4$
    // Latte = 350 ml water , 75 ml milk , 20 g coffee beans , cost 7$
    // Cappuccino = 200 ml water , 100 ml milk , 12 g coffee beans, cost 6$

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();

        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            System.out.print("> ");
            action = scanner.next();
            System.out.println();

            if (Objects.equals(action, "buy")) {
                machine.BuyCoffee();
            }

            if (Objects.equals(action, "fill")) {
                machine.FillMachine();
            }

            if (Objects.equals(action, "take")) {
                machine.TakeMoney();
            }
            if (Objects.equals(action, "remaining")) {
                machine.PrintRemaining();
            }
            if (Objects.equals(action, "exit")) {
                System.exit(0);
            }

        }


    }

    public void PrintRemaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disCups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();

    }

    public void BuyCoffee() {
        String option;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        System.out.print("> ");
        option = scanner.next();
        if (disCups > 0) {
            if (Objects.equals(option, "1")) {
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water = water - 250;
                    coffeeBeans = coffeeBeans - 16;
                    disCups--;
                    money = money + 4;
                }

            } else if (Objects.equals(option, "2")) {
                if(water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water = water - 350;
                    milk = milk - 75;
                    coffeeBeans = coffeeBeans - 20;
                    disCups--;
                    money = money + 7;
                }

            } else if (Objects.equals(option, "3")) {
                if(water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water = water - 200;
                    milk = milk - 100;
                    coffeeBeans = coffeeBeans - 12;
                    disCups--;
                    money = money + 6;
                }

            }
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void FillMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        System.out.print("> ");
        water = water + scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        System.out.print("> ");
        milk = milk + scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add: ");
        System.out.print("> ");
        coffeeBeans = coffeeBeans + scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        System.out.print("> ");
        disCups = disCups + scanner.nextInt();

    }

    public void TakeMoney() {
        System.out.println("I gave you $" +money );
        money = 0;
        System.out.println();
    }


}
