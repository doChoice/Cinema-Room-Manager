package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        CinemaTheatre cinema = new CinemaTheatre(rows, seats);

        while (true) {
            printMenu();
            int item = scanner.nextInt();
            System.out.println();
            switch (item) {
                case 1:
                    cinema.printMap();
                    break;
                case 2:
                    cinema.checkPriceAndBookSeat();
                    break;
                case 3:
                    cinema.printStatistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.printf("\"%s\" - incorrect number entered! Please try again.%n", item);
                    break;
            }
        }
    }

    private static void printMenu() {
        Menu[] menu = Menu.values();
        System.out.println();
        for (Menu elem: menu) {
            System.out.println(elem);
        }
    }
}