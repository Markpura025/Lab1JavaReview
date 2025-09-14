import java.util.Scanner;
public class LAB1javaReview {
	
	static Scanner scanner = new Scanner(System.in);
	
	static final int MAX_BOOKS = 5;
    private static String[] titles = new String[MAX_BOOKS];
    private static String[] status = new String[MAX_BOOKS];
    static int bookCount = 0; 
    static String books[] = new String[5];
    static String statuses[] = new String[5];
    static int choice;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        
        do {
        System.out.println("_______________________________");
        System.out.println("\nWELCOME TO LIBRARY MANAGEMENT");	
        System.out.println("\n_______________________________");
        System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter the number: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBookStatus(sc);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Thankyou for Using and Goodbye!");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("\nCannot add more than 5 books.");
            return;
        }
        System.out.println("===============================");
        System.out.print("Enter the book title: ");
        String title = sc.nextLine();

        titles[bookCount] = title;          
        status[bookCount] = "Available";    
        bookCount++;                        

        System.out.println("The book is added successfully!");
    }

    
    public static void updateBookStatus(Scanner sc) {
        if (bookCount == 0) {
            System.out.println("No books available to update.");
            return;
        }

        showBooks();
        System.out.print("\nEnter book number to update: ");
        int num = sc.nextInt();
        sc.nextLine(); 

        if (num < 1 || num > bookCount) {
            System.out.println("Invalid book number.");
            return;
        }

        int index = num - 1; 
        if (status[index].equals("Available")) {
            status[index] = "Borrowed";
        } else {
            status[index] = "Available";
        }

        System.out.println(" Status updated.");
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("None.");
            return;
        }
        System.out.println("\n===============================");
        System.out.println("\nBooks in the system");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". Title: " + titles[i] + " | Status: " + status[i]);
        }
    }
   
    public static void generateReport() {
        int available = 0;
        int borrowed = 0;

        for (int i = 0; i < bookCount; i++) {
            if (status[i].equals("Available")) {
                available++;
            } else {
                borrowed++;
            }
        }
        
        System.out.println("\n===============================");
        System.out.println("\nBook Report ");
        System.out.println("Overall books: " + bookCount);
        System.out.println("Available books: " + available);
        System.out.println("Borrowed books: " + borrowed);
    }
}