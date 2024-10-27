package vinay;

import java.util.Scanner;

class Book {
    String title;
    String author;
    int id;

    Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}