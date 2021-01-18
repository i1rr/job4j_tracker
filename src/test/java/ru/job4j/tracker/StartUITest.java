package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new InputStub(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(),
                new ActionExit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenActionEdit() {
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "zyx", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(),
                new ActionEdit(),
                new ActionExit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("zyx"));
    }

    @Test
    public void whenActionDelete() {
        Input in = new InputStub(
                new String[]{"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(),
                new ActionDelete(),
                new ActionExit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }
}
 */