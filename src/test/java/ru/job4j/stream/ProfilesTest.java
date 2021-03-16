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
        List<Profile> input = List.of(
                new Profile(sydney),
                new Profile(china)
        );
        Profiles pro = new Profiles();
        assertThat(pro.collect(input).toString(), is(
                "[0/74 Napoleon st. Sydney, 19293/7 Shun dzhu. Pekin]"));
    }
}