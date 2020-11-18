package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select menu: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== Showing all items ===" + System.lineSeparator());
                tracker.findAll();

            } else if (select == 2) {
                System.out.println("=== Edit an item ===" + System.lineSeparator());
                int id = Integer.valueOf(input.askStr("Enter ID to replace: "));
                System.out.println();
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.replace(id, item);

            } else if (select == 3) {
                System.out.println("=== Delete an item ===" + System.lineSeparator());
                int id = Integer.valueOf(input.askStr("Enter item's ID: "));
                tracker.delete(id);

            } else if (select == 4) {
                System.out.println("=== Find an item by ID ===" + System.lineSeparator());
                int id = Integer.valueOf(input.askStr("Enter ID: "));
                tracker.findById(id);

            } else if (select == 5) {
                System.out.println("=== Find an item by Name ===" + System.lineSeparator());
                String name = input.askStr("Enter name: ");
                tracker.findByName(name);

            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.print(System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit Program" + System.lineSeparator()
                + System.lineSeparator());
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}