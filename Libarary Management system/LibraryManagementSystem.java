package vinay;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static Book[] books = new Book[100]; // Array to hold books
    private static int count = 0; // Number of books

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Book Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Author");
            System.out.println("3. Delete Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    books[count] = new Book(title, author, count + 1); // Assign ID as count + 1
                    count++;
                    System.out.println("Book added successfully.");
                    break;

                case 2: // Update Book Author
                    System.out.print("Enter Book ID to update author: ");
                    int idToUpdate = scanner.nextInt();
                    if (idToUpdate > 0 && idToUpdate <= count) {
                        System.out.print("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        books[idToUpdate - 1].author = newAuthor; // Update directly
                        System.out.println("Author updated successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3: // Delete Book
                    System.out.print("Enter Book ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    if (idToDelete > 0 && idToDelete <= count) {
                        for (int i = idToDelete - 1; i < count - 1; i++) {
                            books[i] = books[i + 1]; // Shift books left
                        }
                        books[count - 1] = null; // Clear last book reference
                        count--;
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4: // Display Books
                    System.out.println("Book List:");
                    for (int i = 0; i < count; i++) {
                        books[i].display();
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
