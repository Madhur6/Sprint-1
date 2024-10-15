class Booking {
    String customerName;
    Train train;
    int numTickets;

    public Booking(String customerName, Train train, int numTickets) {
        this.customerName = customerName;
        this.train = train;
        this.numTickets = numTickets;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Train: " + train.trainName + " (Train Number: " + train.trainNumber + ")");
        System.out.println("From: " + train.origin + " To: " + train.destination);
        System.out.println("Number of Tickets: " + numTickets);
        System.out.println("Departure Time: " + train.departureTime);
        System.out.println("Arrival Time: " + train.arrivalTime);
        System.out.println("------------------------");
    }
}
