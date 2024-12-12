package Lift;

import java.util.Scanner;

public class LiftView {
    private LiftModel model;
    Scanner scanner = new Scanner(System.in);

    public LiftView() {
        model = new LiftModel(this);
    }

    public void getUserAction() {
        while (true) {
            System.out.println("Lift Service");
            System.out.println("1. Display lift positions");
            System.out.println("2. Assign lift");
            System.out.println("0. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayLifts();
                    break;

                case 2:
                    assignLift();
                    break;

                case 0:
                    System.out.println("Power Down");
                    return;

                default:
                    System.out.println();
                    System.out.println("You have entered a wrong choice!!!");
                    break;
            }
        }
    }

    public void display(String alert) {
        System.out.println(alert);
    }

    public void displayLifts() {
        model.displayLiftPosition();
    }

    public void assignLift() {
        int passengerFloor = scanner.nextInt();
        int destinationFloor = scanner.nextInt();
        System.out.println();
        System.out.println("Do you want the nearest lift?");
        System.out.println("y - yes");
        System.out.println("n - no");
        System.out.println("s - same direction");
        System.out.print("Enter your choice : ");
        System.out.println();
        char c = scanner.next().toLowerCase().charAt(0);
        if (c == 'y') {
            model.assignNearestLift(passengerFloor, destinationFloor);
        } else if (c == 'n') {
            model.assignLift(passengerFloor, destinationFloor);
        } else if (c == 's') {
            model.assignLiftInSameDirection(passengerFloor, destinationFloor);
        }
        model.displayLiftPosition();
        System.out.println();
    }
}
