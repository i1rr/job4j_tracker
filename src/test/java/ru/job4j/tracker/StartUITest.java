package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final String ln = System.lineSeparator();

   @Test
    public void whenCreateItem() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenActionEdit() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "zyx", "2"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionEdit(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("zyx"));
    }

    @Test
    public void whenActionDelete() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionDelete(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "2"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionFindAll(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        String time = tracker.findById(1).toString();
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Showing all items" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Showing all items" + ln
                + "2. >>> Exit Program" + ln + ln + ln
                + time + ln + ln + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Showing all items" + ln
                + "2. >>> Exit Program" + ln + "Game over" + ln)
        );
    }

    @Test
    public void whenFindByID() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionFindByID(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        String time = tracker.findById(1).toString();
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by ID" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by ID" + ln
                + "2. >>> Exit Program" + ln + ln
                + time + ln + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by ID" + ln
                + "2. >>> Exit Program" + ln + "Game over" + ln)
        );
    }

    @Test
    public void whenFindByName() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "Item name", "2"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(out));
        actions.add(new ActionFindByName(out));
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        String time = tracker.findById(1).toString();
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by Name" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by Name" + ln
                + "2. >>> Exit Program" + ln
                + time + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by Name" + ln
                + "2. >>> Exit Program" + ln + "Game over" + ln)
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ActionExit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. >>> Exit Program" + ln
                        + "Menu." + ln
                        + "0. >>> Exit Program" + ln
                        + "Game over" + ln)
        );
    }

    @Test
    public void whenValidInput() {
        Input in = new InputStub(
                new String[] {"1"}
        );
        int selected = in.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Input in = new InputStub(
                new String[] {"1", "2", "3"}
        );
        for (int i = 0; i < 3; i++) {
            int selected = in.askInt("Enter menu: ");
            assertThat(selected, is(i + 1));
        }
    }

    @Test
    public void whenInputIsNegative() {
        Output out = new OutputStub();

        //Валидейт тут излишен, но просто для себя, для понимания что, как, и к чему прикручивается
        Input in = new InputValidate(out, new InputStub(
                new String[] {"-1"}
        ));

        int selected = in.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }
}