package ru.job4j.tracker;

import org.junit.Test;
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
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenActionEdit() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "zyx", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionEdit(out),
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("zyx"));
    }

    @Test
    public void whenActionDelete() {
        Output out = new OutputStub();
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionDelete(out),
                new ActionExit(out)
        };
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
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionFindAll(out),
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Showing all items" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Showing all items" + ln
                + "2. >>> Exit Program" + ln + ln + ln
                + "Item{id=1, name='Item name', created=27-01-2021}" + ln + ln + ln
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
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionFindByID(out),
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by ID" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by ID" + ln
                + "2. >>> Exit Program" + ln + ln
                + "Item{id=1, name='Item name', created=27-01-2021}" + ln + ln
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
        UserAction[] actions = {
                new ActionCreate(out),
                new ActionFindByName(out),
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by Name" + ln
                + "2. >>> Exit Program" + ln
                + "Menu." + ln
                + "0. >>> Create a new Item" + ln
                + "1. >>> Find an item by Name" + ln
                + "2. >>> Exit Program" + ln
                + "Item{id=1, name='Item name', created=27-01-2021}" + ln
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
        UserAction[] actions = {
                new ActionExit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is (
                        "Menu." + ln
        + "0. >>> Exit Program" + ln
        + "Menu." + ln
        + "0. >>> Exit Program" + ln
        + "Game over" + ln)
        );
    }
}