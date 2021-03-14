package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = x -> x.getName().contains(key);
        Predicate<Person> checkLastName = x -> x.getLastName().contains(key);
        Predicate<Person> checkPhone = x -> x.getPhone().contains(key);
        Predicate<Person> checkAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = checkName.or(checkLastName).or(checkPhone).or(checkAddress);
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person gg : persons) {
            if (combine.test(gg)) {
                rsl.add(gg);
            }
        }
        return rsl;
    }
}
