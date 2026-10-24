
package cli;

import java.util.Scanner;

import backend.Appointment;
import backend.AppointmentManager;

public class AppointmentMenu {

    private final Scanner scanner;
    private final AppointmentManager manager;

    public AppointmentMenu(AppointmentManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> createAppointment();
                case 2 -> manager.viewAppointments();
                case 3 -> updateAppointment();
                case 4 -> cancelAppointment();
                case 5 -> manager.viewAppointmentsSortedByDate();
                case 6 -> manager.viewAppointmentQueue();
                case 7 -> manager.viewRecentAppointments();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Try again.");
            }

            System.out.println();

        } while (choice != 0);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("==========================================");
        System.out.println("       LAUNDRY APPOINTMENT SYSTEM");
        System.out.println("                DSA EDITION");
        System.out.println("==========================================");
        System.out.println("[1] Create Appointment");
        System.out.println("[2] View Appointments");
        System.out.println("[3] Update Appointment");
        System.out.println("[4] Cancel Appointment");
        System.out.println("[5] Sort Appointments by Date (Bubble Sort)");
        System.out.println("[6] View Appointment Queue (FIFO)");
        System.out.println("[7] View Recent Appointments (Stack/LIFO)");
        System.out.println("[0] Exit");
        System.out.println("==========================================");
    }

    private void createAppointment() {
        System.out.println("\n--- CREATE APPOINTMENT ---");

        String reference = readText("Reference number: ");
        String name = readText("Customer name: ");
        String date = readText("Appointment date (YYYY-MM-DD): ");
        String time = readText("Appointment time: ");
        String service = readText("Laundry service: ");
        String status = readText("Status: ");

        Appointment appointment = new Appointment(
                reference, name, date, time, service, status
        );

        manager.createAppointment(appointment);
    }

    private void updateAppointment() {
        System.out.println("\n--- UPDATE APPOINTMENT ---");

        String reference = readText("Reference number to update: ");

        if (manager.searchAppointment(reference) == null) {
            System.out.println("Appointment not found.");
            return;
        }

        String name = readText("New customer name: ");
        String date = readText("New appointment date (YYYY-MM-DD): ");
        String time = readText("New appointment time: ");
        String service = readText("New laundry service: ");

        manager.updateAppointment(
                reference, name, date, time, service
        );
    }

    private void cancelAppointment() {
        System.out.println("\n--- CANCEL APPOINTMENT ---");

        String reference = readText("Reference number to cancel: ");
        manager.cancelAppointment(reference);
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
