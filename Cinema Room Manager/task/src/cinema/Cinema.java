package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Write your code here
        CinemaHall cinema = new CinemaHall(inputRows(), inputSeats());
        showMenu(cinema);
    }

    static void showMenu(CinemaHall cinema) {
        int option;
        do {
            option = inputMenuOption();
            switch (option) {
                case 1:
                    cinema.printCinemaSeats();
                    break;
                case 2:
                    // User chooses a seat and the Cinema Hall is updated
                    cinema.buyTicket();
                    break;
                case 3:
                    cinema.statistics();
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        } while (option !=0);
    }

    static int inputRows() {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }

    static int inputSeats() {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    static int inputRow() {
        System.out.println("Enter a row number:");
        return scanner.nextInt();
    }

    static int inputSeat() {
        System.out.println("Enter a seat number in that row:");
        return scanner.nextInt();
    }

    static int inputMenuOption() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        return scanner.nextInt();
    }
}

class CinemaHall {
    int rows;
    int seatsInRow;
    private char[][] layout;
    int rowNumber;
    int seatNumber;
    private static int numberTickets = 0;
    private static final int SEATS_SMALL_ROOM = 60;
    private static final int PRICE_FRONT_ROWS = 10;
    private static final int PRICE_BACK_ROWS = 8;
    CinemaHall(int rows, int seatsInRow) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.setLayout();
    }

    void statistics() {
        // Prints the statistics
        System.out.println("Number of purchased tickets: " + getNumberTickets());
        System.out.printf("Percentage: %.2f%%%n", percentage());
        System.out.println("Current income: $" + currentIncome());
        System.out.println("Total income: $" + totalIncome());
    }
    int getNumberTickets() {
        return numberTickets;
    }

    double percentage() {
        return (double) numberTickets / rows / seatsInRow * 100;
    }

    int currentIncome() {
        // Calculates the amount of money made
        int income = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                if (layout[i][j] == 'B') {
                    income += getTicketPrice(i + 1);
                }
            }
        }
        return income;
    }

    int totalIncome() {
        // Calculates total income based on number of seats
        int totalSeats = this.rows * this.seatsInRow;
        if (totalSeats <= SEATS_SMALL_ROOM) {
            return totalSeats * PRICE_FRONT_ROWS;
        } else {
            int frontRows = this.rows / 2;
            return frontRows * this.seatsInRow * PRICE_FRONT_ROWS + (this.rows - frontRows) * this.seatsInRow * PRICE_BACK_ROWS;
        }
    }

    private void setLayout() {
        // Sets the seating arrangements
        this.layout = new char[this.rows][this.seatsInRow];
        for (char[] array : this.layout) {
            Arrays.fill(array,'S');
        }
    }

    void buyTicket() {
        boolean notCorrect = true;

        // Loops until the input is correct
        while (notCorrect) {
            this.rowNumber = Cinema.inputRow();
            this.seatNumber = Cinema.inputSeat();
            if (rowNumber > rows || seatNumber > seatsInRow || rowNumber < 1 || seatNumber < 1) {
                System.out.println("Wrong input!");
            } else if (layout[rowNumber - 1][seatNumber - 1] == 'B') {
                System.out.println("That ticket has already been purchased");
            } else {
                // Updating the seating arrangements
                layout[rowNumber - 1][seatNumber - 1] = 'B';
                // Prints ticket price for user
                System.out.printf("Ticket price: $%d%n", getTicketPrice(this.rowNumber));
                numberTickets++;
                notCorrect = false;
            }
        }
    }

    int getTicketPrice(int rowNumber) {
        // Gets ticket price depending on the total number of seats and row chosen by the customer
        return rows * seatsInRow <= SEATS_SMALL_ROOM ? PRICE_FRONT_ROWS : rowNumber <= rows / 2 ? PRICE_FRONT_ROWS : PRICE_BACK_ROWS;
    }

    void printCinemaSeats() {
        // Print Cinema Hall
        System.out.println("Cinema:");
        for (int j = 1; j <= this.seatsInRow; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        for (int i = 0; i < this.rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < this.seatsInRow; j++) {
                System.out.print(this.layout[i][j] + " ");
            }
            System.out.println();
        }
    }
}
