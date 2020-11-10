package ru.job4j.pojo;

public class Book {
    private String name;
    private int pages;

    @Override
    public String toString() {
        return "Книга: " + name + '\'' +
                ", количество страниц: " + pages +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book() {
        this.name = "Name isn't available";
        this.pages = -1;
    }

    public Book(String name) {
        this.name = name;
        this.pages = -1;
    }

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }
}
