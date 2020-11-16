package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== Showing all items ===");
                tracker.findAll();

            } else if (select == 2) {
                System.out.println("=== Edit an item ===");
                System.out.print("Enter ID to replace: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);

            } else if (select == 3) {
                System.out.println("=== Delete an item ===");
                System.out.print("Enter item's ID: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);

            } else if (select == 4) {
                System.out.println("=== Find an item by ID ===");
                System.out.print("Enter ID: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.findById(id);

            } else if (select == 5) {
                System.out.println("=== Find an item by Name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                tracker.findByName(name);

            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.print("0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by Id" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program" + System.lineSeparator() +
                System.lineSeparator() +
                "Select: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}