class Train {
    String trainNumber;
    String trainName;
    String origin;
    String destination;
    String departureTime;
    String arrivalTime;
    int availableSeats;
    int totalSeats;

    public Train(String trainNumber, String trainName, String origin, String destination,
                 String departureTime, String arrivalTime, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void displayTrainDetails() {
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("From: " + origin + " To: " + destination);
        System.out.println("Departure: " + departureTime + " Arrival: " + arrivalTime);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("------------------------");
    }

    public void displayOccupancy() {
        int occupiedSeats = totalSeats - availableSeats;
        System.out.println("Train " + trainName + " (" + trainNumber + "):");
        System.out.println("Total Seats: " + totalSeats + " | Booked: " + occupiedSeats + " | Available: " + availableSeats);
    }
}
