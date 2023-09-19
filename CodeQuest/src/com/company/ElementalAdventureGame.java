package com.company;
        import java.util.Objects;
        import java.util.Random;
        import java.util.Scanner;

public class ElementalAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("░█████╗░██████╗░██╗░░░██╗███████╗███╗░░██╗████████╗██╗░░░██╗██████╗░███████╗");
        System.out.println("██╔══██╗██╔══██╗██║░░░██║██╔════╝████╗░██║╚══██╔══╝██║░░░██║██╔══██╗██╔════╝");
        System.out.println("███████║██║░░██║╚██╗░██╔╝█████╗░░██╔██╗██║░░░██║░░░██║░░░██║██████╔╝█████╗░░");
        System.out.println("██╔══██║██║░░██║░╚████╔╝░██╔══╝░░██║╚████║░░░██║░░░██║░░░██║██╔══██╗██╔══╝░░");
        System.out.println("██║░░██║██████╔╝░░╚██╔╝░░███████╗██║░╚███║░░░██║░░░╚██████╔╝██║░░██║███████╗");
        System.out.println("╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚═════╝░╚═╝░░╚═╝╚══════╝\n");

        System.out.println("██████╗░███████╗░██████╗░██╗███╗░░██╗░██████╗");
        System.out.println("██╔══██╗██╔════╝██╔════╝░██║████╗░██║██╔════╝");
        System.out.println("██████╦╝█████╗░░██║░░██╗░██║██╔██╗██║╚█████╗░");
        System.out.println("██╔══██╗██╔══╝░░██║░░╚██╗██║██║╚████║░╚═══██╗");
        System.out.println("██████╦╝███████╗╚██████╔╝██║██║░╚███║██████╔╝");
        System.out.println("╚═════╝░╚══════╝░╚═════╝░╚═╝╚═╝░░╚══╝╚═════╝░");
        System.out.println("Welcome to the Elemental Adventure Game!");

        String name = getPlayerName(scanner);
        System.out.println("Welcome, " + name + "!");

        int swordMoves = generateSwordMoves();
        System.out.println("You have " + swordMoves + " sword moves.");

        boolean validDirection = false;
        String element = "";
        while (!validDirection) {
            System.out.println("You find yourself at a crossroads in a mystical forest.");
            System.out.println("Each direction leads to a different elemental realm:");
            System.out.println("NORTH (Ice), SOUTH (Fire), EAST (Water), WEST (Earth)");

            System.out.print("Choose a direction: ");
            String direction = scanner.nextLine().toUpperCase();
            element = getElement(direction);

            if (element.equals("Unknown")) {
                System.out.println("Invalid direction. Please choose a valid direction.");
            } else {
                validDirection = true;
            }
        }

        System.out.println("You've chosen the path of " + element + ".");
        System.out.println("As you venture deeper, you encounter...");

        int remainingPower = swordMoves;

        for (int i = 0; i < 3; i++) {
            int creaturePower = new Random().nextInt(4) + 1; // Random creature power (1 to 4)
            System.out.println("... a small " + element + " creature!");

            remainingPower = fightCreature(remainingPower, creaturePower);

            if (remainingPower <= 0) {
                System.out.println("You ran out of power. Game over!");
                return;
            }
            System.out.println("You've defeated the small " + element + " creature!");

            System.out.println("You've " + remainingPower + " moves!!");

            System.out.println("You again started to walk and encounter...");
        }
        System.out.println("You started to go deeper and came across a cave..");

        System.out.println("Its a spooky and dark cave and looking dangerous....");

        System.out.println("Want to continue the adventure or quit??(y/n):");

        String choice = scanner.nextLine();

        if(Objects.equals(choice, "y")) {
            int mainCreaturePower = new Random().nextInt(6) + 10; // Random main creature power (10 to 15)
            System.out.println("A powerful " + element + " creature appears!");

            remainingPower = fightMainCreature(remainingPower, mainCreaturePower);

            System.out.println("You've " + remainingPower + " moves!!");
            if (remainingPower <= 0) {
                System.out.println("You ran out of power. Game over!");
            } else {
                System.out.println("Congratulations!!");

                System.out.println("You've defeated the " + element + " creature and completed your adventure!");


            }
        }
        else{
            System.out.println("You've completed your adventure!");
            System.out.println("Congratulations!!");
        }

        System.out.println("████████╗██╗░░██╗░█████╗░███╗░░██╗██╗░░██╗	██╗░░░██╗░█████╗░██╗░░░██╗");
        System.out.println("╚══██╔══╝██║░░██║██╔══██╗████╗░██║██║░██╔╝	╚██╗░██╔╝██╔══██╗██║░░░██║");
        System.out.println("░░░██║░░░███████║███████║██╔██╗██║█████═╝░	░╚████╔╝░██║░░██║██║░░░██║");
        System.out.println("░░░██║░░░██╔══██║██╔══██║██║╚████║██╔═██╗░	░░╚██╔╝░░██║░░██║██║░░░██║");
        System.out.println("░░░██║░░░██║░░██║██║░░██║██║░╚███║██║░╚██╗	░░░██║░░░╚█████╔╝╚██████╔╝");
        System.out.println("░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝	░░░╚═╝░░░░╚════╝░░╚═════╝░");
    }

    private static String getPlayerName(Scanner scanner) {
        System.out.print("What is your name? ");
        return scanner.nextLine();
    }

    private static int generateSwordMoves() {
        return new Random().nextInt(6) + 5;
    }

    private static String getElement(String direction) {
        switch (direction) {
            case "NORTH":
                return "Ice";
            case "SOUTH":
                return "Fire";
            case "EAST":
                return "Water";
            case "WEST":
                return "Earth";
            default:
                return "Unknown";
        }
    }

    private static int fightCreature(int power, int creaturePower) {
        Scanner scanner = new Scanner(System.in);

        while (creaturePower > 0) {
            System.out.println("The creature attacks!");

            System.out.print("Do you want to attack (A) or dodge (D)? ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("A")) {
                int damage = new Random().nextInt(3) + 1; // Random damage (1 to 3)
                creaturePower -= damage;
                power--;
                System.out.println("You dealt " + damage + " damage to the creature.");

                System.out.println("You've " + power + " moves!!");
            } else if (action.equals("D")) {
                System.out.println("You dodged the attack!");
            } else {
                System.out.println("Invalid action. Choose A to attack or D to dodge.");
                continue;
            }

            System.out.println("The creature has " + creaturePower + " power remaining.");
            creaturePower--;
        }

        return power;
    }

    private static int fightMainCreature(int power, int creaturePower) {
        Scanner scanner = new Scanner(System.in);

        while (creaturePower > 0) {
            System.out.println("The creature attacks!");

            System.out.print("Do you want to attack (A) or dodge (D)? ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("A")) {
                int damage = new Random().nextInt(creaturePower) + 1; // Random damage (1 to creaturePower)
                creaturePower -= damage;
                power--;
                System.out.println("You dealt " + damage + " damage to the creature.");

                System.out.println("You've " + power + " moves!!");
            } else if (action.equals("D")) {
                System.out.println("You dodged the attack!");

            } else {
                System.out.println("Invalid action. Choose A to attack or D to dodge.");
                continue;
            }

            System.out.println("The creature has " + creaturePower + " power remaining.");

            creaturePower--;
        }

        return power;
    }
}
