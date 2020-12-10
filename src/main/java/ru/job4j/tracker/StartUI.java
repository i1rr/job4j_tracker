package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(),
                new ActionFindAll(),
                new ActionEdit(),
                new ActionDelete(),
                new ActionFindByID(),
                new ActionFindByName(),
                new ActionExit()

        };
        new StartUI().init(input, tracker, actions);
    }
}

/*
 *
 *     public static void createItem(Input input, Tracker tracker) {
 *         System.out.println("=== Create a new Item ===");
 *         String name = input.askStr("Enter name: ");
 *         Item item = new Item(name);
 *         tracker.add(item);
 *     }
 *
 *     public static void findAllItems(Input input, Tracker tracker) {
 *         System.out.println("=== Showing all items ===" + System.lineSeparator());
 *         tracker.findAll();
 *     }
 *
 *     public static void editItem(Input input, Tracker tracker) {
 *         System.out.println("=== Edit an item ===" + System.lineSeparator());
 *         int id = Integer.valueOf(input.askStr("Enter ID to replace: "));
 *         System.out.println();
 *         String name = input.askStr("Enter name: ");
 *         Item item = new Item(name);
 *         tracker.replace(id, item);
 *     }
 *
 *     public static void deleteItem(Input input, Tracker tracker) {
 *         System.out.println("=== Delete an item ===" + System.lineSeparator());
 *         int id = Integer.valueOf(input.askStr("Enter item's ID: "));
 *         tracker.delete(id);
 *     }
 *
 *     public static void findItemByID(Input input, Tracker tracker) {
 *         System.out.println("=== Find an item by ID ===" + System.lineSeparator());
 *         int id = Integer.valueOf(input.askStr("Enter ID: "));
 *         tracker.findById(id);
 *     }
 *
 *     public static void findItemByName(Input input, Tracker tracker) {
 *         System.out.println("=== Find an item by Name ===" + System.lineSeparator());
 *         String name = input.askStr("Enter name: ");
 *         tracker.findByName(name);
 *     }
 *
 * public void init(Input input, Tracker tracker) {
 * boolean run = true;
 * while (run) {
 * this.showMenu();
 * int select = Integer.valueOf(input.askStr("Select menu: "));
 * if (select == 0) {
 * StartUI.createItem(input, tracker);
 * } else if (select == 1) {
 * StartUI.findAllItems(input, tracker);
 * } else if (select == 2) {
 * StartUI.editItem(input, tracker);
 * } else if (select == 3) {
 * StartUI.deleteItem(input, tracker);
 * } else if (select == 4) {
 * StartUI.findItemByID(input, tracker);
 * } else if (select == 5) {
 * StartUI.findItemByName(input, tracker);
 * } else if (select == 6) {
 * run = false;
 * }
 * }
 * }
 * <p>
 * private void showMenu() {
 * System.out.print(System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
 * + "1. Show all items" + System.lineSeparator()
 * + "2. Edit item" + System.lineSeparator()
 * + "3. Delete item" + System.lineSeparator()
 * + "4. Find item by Id" + System.lineSeparator()
 * + "5. Find items by name" + System.lineSeparator()
 * + "6. Exit Program" + System.lineSeparator()
 * + System.lineSeparator());
 * }
 */