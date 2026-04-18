// This program demonstrates constructor overloading in a Book class.
// It allows creating books with full or partial information,
// prints book details, and calculates discounted price.

public class Book{
    String title;
    String author;
    int pageCount;
    double price;

    Book(String title, String author, int pageCount, double price){
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.pageCount = 0;
        this.price = 0;
    }

    void printInfo(){
        IO.println("Book title: " + title +
                ", Author: " + author +
                ", Page count: " + pageCount +
                ", Price: " + price);
    }

    double discountedPrice(double percent){
        return price * (1 - (0.01 * percent));
    }
}

void main(){
    Book book1 = new Book("Notes from Underground", "Dostoevsky", 124, 65);
    Book book2 = new Book("Man's Search for Meaning", "Victor Hugo");

    book1.printInfo();
    book2.printInfo();

    IO.println("Discounted price of first book: " + book1.discountedPrice(25));
}