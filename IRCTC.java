import java.util.ArrayList;
import java.util.Scanner;

public class IRCTC {
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    static User loggedInUser = null;

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("Welcome to the Railway Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (loggedInUser != null) {
                mainMenu();
            }
        }
    }

    public static void initializeData() {
        trains.add(new Train("12345", "Express", "Jaipur", "Delhi", "09:00", "18:00", 100));
        trains.add(new Train("67890", "FastTrack", "Delhi", "Kota", "10:00", "16:00", 50));
        users.add(new User("madhur", "madhur@123", "Madhur Pandey"));
        users.add(new User("gaurav", "gaurav@123", "Gaurav Nagar"));
    }

    public static void register() {
        System.out.println("Register a new account:");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        if (Authentication.registerUser(username, password, name, users)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Try again.");
        }
    }


    public static void login() {
        System.out.println("Please login to continue.");
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        User user = Authentication.login(username, password, users);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Login successful! Welcome " + user.name);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    public static void mainMenu() {
        while (loggedInUser != null) {
            System.out.println("Main Menu:");
            System.out.println("1. Search for Trains");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View Booking History");
            System.out.println("4. Logout");

            int choice = sc.nextInt();sc.nextLine();

            switch (choice) {
                case 1:
                    searchTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewBookingHistory();
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void logout() {
        System.out.println("Logging out...");
        loggedInUser = null;
    }

    public static void searchTrains() {
        System.out.println("Enter origin:");
        String origin = sc.nextLine();
        System.out.println("Enter destination:");
        String destination = sc.nextLine();

        System.out.println("Available Trains:");
        for (Train train : trains) {
            if (train.origin.equalsIgnoreCase(origin) && train.destination.equalsIgnoreCase(destination)) {
                train.displayTrainDetails();
            }
        }
    }

    public static void bookTicket() {
        System.out.println("Enter train number:");
        String trainNumber = sc.nextLine();
        Train selectedTrain = findTrain(trainNumber);
        if (selectedTrain == null) {
            System.out.println("Train not found!");
            return;
        }

        if (selectedTrain.availableSeats <= 0) {
            System.out.println("No seats available!");
            return;
        }

        System.out.println("How many tickets?");
        
        int numTickets = sc.nextInt();sc.nextLine();

        if (numTickets > selectedTrain.availableSeats) {
            System.out.println("Not enough seats available!");
            return;
        }

        Booking newBooking = new Booking(loggedInUser.username, selectedTrain, numTickets);
        bookings.add(newBooking);
        selectedTrain.availableSeats -= numTickets;
        System.out.println("Booking confirmed for " + numTickets + " tickets!");
    }

    public static void viewBookingHistory() {
        System.out.println("Your Booking History:");
        for (Booking booking : bookings) {
            if (booking.customerName.equals(loggedInUser.username)) {
                booking.displayBookingDetails();
            }
        }
    }

    public static Train findTrain(String trainNumber) {
        for (Train train : trains) {
            if (train.trainNumber.equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
}
