package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book java = new Book();
        java.setTitle("Java Programming");
        java.setPages(320);

        Book css = new Book();
        css.setTitle("CSS");
        css.setPages(190);

        Book cleanCode = new Book();
        cleanCode.setTitle("Clean code");
        cleanCode.setPages(240);

        Book javaAlgorithms = new Book();
        javaAlgorithms.setTitle("Java Algorithms");
        javaAlgorithms.setPages(110);

        Book[] books = {java, css, cleanCode, javaAlgorithms};

        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getPages());
        }
        System.out.println();

        books[0] = javaAlgorithms;
        books[3] = java;

        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getPages());
        }
        System.out.println();

        for (Book book : books) {
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle() + " " + book.getPages());
            }
        }
    }
}
