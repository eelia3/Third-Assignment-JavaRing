package org.project;

import org.project.entity.players.*;
import org.project.entity.enemies.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Java-Ring: A Turn-Based RPG!");
        System.out.println("Choose your character:");
        System.out.println("1. Knight ⚔️");
        System.out.println("2. Assassin 🗡️");
        System.out.println("3. Mage 🧙‍♂️");

        Player player = null;
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> player = new Knight();
            case 2 -> player = new Assasin();
            case 3 -> player = new Mage();
            default -> {
                System.out.println("Invalid choice. Exiting game.");
                System.exit(0);
            }
        }

        System.out.println("You have chosen: " + player.getName());
        System.out.println("Let the adventure begin!");

        while (player.getHp() > 0) {
            Enemy enemy = generateRandomEnemy(random);

            System.out.println("\nA wild " + enemy.name + " appears with " + enemy.getHp() + " HP!");
            while (enemy.getHp() > 0 && player.getHp() > 0) {
                System.out.println("\nChoose your action:");
                System.out.println("1. Attack");
                System.out.println("2. Defend");
                System.out.println("3. Use Flask");
                System.out.println("4. Use Special Ability");
                System.out.println("5. Stop Defending");

                int action = scanner.nextInt();
                switch (action) {
                    case 1 -> {
                        enemy.takeDamage(player.getWeapon().getDamage());
                        System.out.println(enemy.name + " took damage and now has " + enemy.getHp() + " HP remaining.");
                    }
                    case 2 -> {
                        player.defend();
                        System.out.println(player.getName() + " is defending.");
                    }
                    case 3 -> {
                        player.flaskheal();
                        System.out.println(player.getName() + " healed using a flask and now has " + player.getHp() + " HP remaining.");
                    }
                    case 4 -> {
                        player.oldTrickInTheBook(enemy);
                        System.out.println(enemy.name + " took damage and now has " + enemy.getHp() + " HP remaining.");
                    }
                    case 5 -> {
                        player.stopDefending();
                        System.out.println(player.getName() + " stopped defending.");
                    }
                    default -> System.out.println("Invalid action. Try again.");
                }

                if (enemy instanceof Skeleton skeletonEnemy) {
                    skeletonEnemy.checkResurrect();
                }

                if (enemy.getHp() > 0) {
                    System.out.println("\n" + enemy.name + "'s turn:");
                    enemy.speshialmove(player);
                    System.out.println(player.getName() + " took damage and now has " + player.getHp() + " HP remaining.");
                }
            }

            if (enemy.getHp() <= 0 && !(enemy instanceof Skeleton skeletonEnemy && skeletonEnemy.checkResurrect())) {
                System.out.println("You have defeated the " + enemy.name + "!");
                break; // بازی تمام می‌شود زیرا دشمن کشته شده است.
            }

            if (player.getHp() <= 0) {
                System.out.println("You have been defeated. Game Over.");
                break;
            }
        }

        scanner.close();
    }

    private static Enemy generateRandomEnemy(Random random) {
        int enemyType = random.nextInt(3);
        return switch (enemyType) {
            case 0 -> new Goblin();
            case 1 -> new Skeleton();
            case 2 -> new Dragon();
            default -> null;
        };
    }
}
