package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for(Person gg : persons) {
            if(
                       gg.getName().contains(key)
                    || gg.getLastName().contains(key)
                    || gg.getPhone().contains(key)
                    || gg.getAddress().contains(key)
            ) {
                result.add(gg);
            }
        }
        return result;
    }
}
