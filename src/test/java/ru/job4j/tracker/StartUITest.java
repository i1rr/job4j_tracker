package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

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
        Output resultOut = new OutputStub();
        resultOut.println("Item{id=1, name='Item name', created=24-01-2021}");
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
        assertThat(tracker.findAll(), is(resultOut));
    }
}
