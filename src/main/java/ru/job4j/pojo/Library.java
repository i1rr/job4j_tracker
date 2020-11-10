package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 250);
        Book warAndPeace = new Book("Война и Мир", 1000000);
        Book hustle = new Book("Журнал Hustle", 20);
        Book bukvar = new Book("Букварь", 36);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = warAndPeace;
        books[2] = hustle;
        books[3] = bukvar;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }

        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;

        for (Book book : books) {
            System.out.println(book);
        }

        for (Book book : books) {
            if(book.getName().equals("Clean Code")) {
                System.out.println(book);
            }
        }
    }
}
