import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class librarycatalog{
private String title;
private String author;

public librarycatalog(String title, String author) {
this.title = title;
this.author = author;
}

public String getTitle() {
return title;
}

public String getAuthor() {
return author;
}

@Override
public String toString() {
return "Title: " + title + ", Author: " + author;
}
}

class Library {
private List<Book> books;

public Library() {
this.books = new ArrayList<>();
}

public void addBook(String title, String author) {
books.add(new Book(title, author));
System.out.println("Book added: " + title);
}

public void searchByTitle(String title) {
for (Book book : books) {
if (book.getTitle().equalsIgnoreCase(title)) {
System.out.println("Found: " + book);
return;
}
}
System.out.println("No book found with title: " + title);
}

public void searchByAuthor(String author) {
boolean found = false;
for (Book book : books) {
if (book.getAuthor().equalsIgnoreCase(author)) {
System.out.println("Found: " + book);
found = true;
}
}
if (!found) {
System.out.println("No books found by author: " + author);
}
}

public void listBooks() {
if (books.isEmpty()) {
System.out.println("No books in the library.");
} else {
System.out.println("Books in the library:");
for (Book book : books) {
System.out.println(book);
}
}
}
}

public class LibraryCatalog {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Library library = new Library();
String command;

System.out.println("Welcome to the Library Catalog System");

do {
System.out.println("\nAvailable commands: add, search, list, exit");
System.out.print("Enter command: ");
command = scanner.nextLine();

switch (command.toLowerCase()) {
case "add":
System.out.print("Enter book title: ");
String title = scanner.nextLine();
System.out.print("Enter book author: ");
String author = scanner.nextLine();
library.addBook(title, author);
break;
case "search":
System.out.print("Search by (title/author): ");
String searchType = scanner.nextLine();
if (searchType.equalsIgnoreCase("title")) {
System.out.print("Enter title: ");
String searchTitle = scanner.nextLine();
library.searchByTitle(searchTitle);
} else if (searchType.equalsIgnoreCase("author")) {
System.out.print("Enter author: ");
String searchAuthor = scanner.nextLine();
library.searchByAuthor(searchAuthor);
} else {
System.out.println("Invalid search type. Please use 'title' or 'author'.");
}
break;
case "list":
library.listBooks();
break;
case "exit":
System.out.println("Exiting the library catalog system. Goodbye!");
break;
default:
System.out.println("Invalid command. Please try again.");
}
} while (!command.equalsIgnoreCase("exit"));

scanner.close();
}
}
