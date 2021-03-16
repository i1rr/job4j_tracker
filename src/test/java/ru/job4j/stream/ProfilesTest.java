package ru.job4j.stream;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void collect() {
        Address sydney = new Address("Sydney", "Napoleon st", 74, 0);
        Address china = new Address("Pekin", "Shun dzhu", 7, 19293);
        Address russia = new Address("St. Petersburg", "Ulica lenina", 3, 14);
        List<Profile> input = List.of(
                new Profile(sydney),
                new Profile(china),
                new Profile(sydney),
                new Profile(china),
                new Profile(russia)
        );
        Profiles pro = new Profiles();
        assertThat(pro.collect(input), is(List.of(china, russia, sydney)));
    }
}