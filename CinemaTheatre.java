package cinema;


import java.util.Scanner;

public class CinemaTheatre {
    private final int rows;
    private final int seatsInRow;
    private int currentIncome;
    private int numberOfPurchasedTicket = 0;
    private final int TICKET_FIRST_HALF_SEATS = 10;
    private final int TICKET_SECOND_HALF_SEATS = 8;
    private String[][] seatsMap;
    private final Scanner scanner = new Scanner(System.in);

    public CinemaTheatre(int rows, int seatsInRow) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.currentIncome = 0;
        this.seatsMap = createMap();
    }

    private String[][] createMap() {
        seatsMap = new String[rows + 1][seatsInRow + 1];
        for (int i = 0; i < seatsMap.length; i++) {
            for (int j = 0; j < seatsMap[0].length; j++) {
                if (i == 0 && j == 0) {
                    seatsMap[i][j] = " ";
                } else if (i == 0) {
                    seatsMap[i][j] = String.valueOf(j);
                } else {
                    if (j == 0) {
                        seatsMap[i][j] = String.valueOf(i);
                    } else {
                        seatsMap[i][j] = "S";
                    }
                }
            }
        }
        return seatsMap;
    }

    void checkPriceAndBookSeat() {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            System.out.println();
            if (row > rows || seat > seatsInRow) {
                System.out.println("Wrong input!");
                System.out.println();
            } else if ("B".equals(seatsMap[row][seat])){
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                int price = getTicketPrice(row);
                System.out.printf("Ticket price: $%d%n%n", price);
                currentIncome += price;
                numberOfPurchasedTicket++;
                seatsMap[row][seat] = "B";
                return;
            }
        }
    }

    int getTicketPrice(int row) {
        if (rows * seatsInRow < 60 || row <= rows / 2) {
            return TICKET_FIRST_HALF_SEATS;
        } else {
            return TICKET_SECOND_HALF_SEATS;
        }
    }

    int calculateTotalIncome() {
        int seats = rows * seatsInRow;
        int seatsInFirstHalf = (rows / 2) * seatsInRow;
        if (seats <= 60) {
            return seats * TICKET_FIRST_HALF_SEATS;
        } else {
            return seatsInFirstHalf * TICKET_FIRST_HALF_SEATS + (seats - seatsInFirstHalf) * TICKET_SECOND_HALF_SEATS;
        }
    }

    void printMap() {
        System.out.println("Cinema:");
        for (String[] arr: seatsMap) {
            for (String str: arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printStatistics() {
        System.out.printf("Number of purchased tickets: %d%n", numberOfPurchasedTicket);
        System.out.printf("Percentage: %.2f%%%n", ((float) numberOfPurchasedTicket / (rows * seatsInRow)) * 100);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", calculateTotalIncome());
    }

}

