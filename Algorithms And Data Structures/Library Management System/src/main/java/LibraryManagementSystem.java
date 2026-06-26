import java.util.Scanner;

class Book{
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display(){
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println();
    }
}

public class LibraryManagementSystem {
    static Book[] books = new Book[100];
    static int bookCount = 0;

    public static void addBook(int bookId, String title, String author){
        books[bookCount] = new Book(bookId, title, author);
        bookCount++;
    }

    public static void linearSearch(String title){
        for(int i = 0; i<bookCount; i++){
            if(books[i].title.equalsIgnoreCase(title)){
                books[i].display();
                return;
            }
        }
        System.out.println("\nBook Not Found");
    }

    public static void binarySearch(String title){
        int low = 0;
        int high = bookCount - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int result = books[mid].title.compareToIgnoreCase(title);

            if(result == 0){
                books[mid].display();
                return;
            }
            else if(result < 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("\nBook Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        addBook(1, "Book 1", "Author 1");
        addBook(2, "Book 2", "Author 2");
        addBook(3, "Book 3", "Author 3");

        System.out.println("\n--- Library Book Search ---");
        System.out.println("\n1. Linear Search");
        System.out.println("\n2. Binary Search");

        while(true){
            System.out.print("\nChoose A Search Algorithm To Search For A Book: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice !=1 && choice !=2){
                System.out.println("\nInvalid Choice");
                continue;
            }

            System.out.print("\nEnter Book Title To Search: ");
            String bookTitle = sc.nextLine();

            switch(choice){
                case 1:
                    linearSearch(bookTitle);
                    break;
                case 2:
                    binarySearch(bookTitle);
                    break;
                default:
                    System.out.println("\nInvalid Choice");
                    return;
            }
        }
    }
}
