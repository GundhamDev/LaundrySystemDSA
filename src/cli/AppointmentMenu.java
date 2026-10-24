
package cli;

import backend.Appointment;
import backend.AppointmentManager;
import java.util.Scanner;

public class AppointmentMenu {
    private final AppointmentManager manager;
    private final Scanner scanner;

    public AppointmentMenu(AppointmentManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n=== APPOINTMENT SYSTEM ===");
            System.out.println("[1] Create Appointment");
            System.out.println("[2] View Appointments");
            System.out.println("[3] Update Appointment");
            System.out.println("[4] Cancel Appointment");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    createAppointment();
                    break;
                case 2:
                    manager.viewAllAppointments();
                    break;
                case 3:
                    updateAppointment();
                    break;
                case 4:
                    cancelAppointment();
                    break;
                case 0:
                    System.out.println("Exiting appointment system.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);
    }

    private void createAppointment() {
        System.out.print("Customer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Laundry service: ");
        String service = scanner.nextLine().trim();

        System.out.print("Appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        if (name.isEmpty() || service.isEmpty() || date.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        Appointment appointment =
                manager.createAppointment(name, service, date);

        System.out.println("Appointment created successfully!");
        System.out.println(appointment);
    }

    private void updateAppointment() {
        System.out.print("Enter appointment ID to update: ");
        int id = readInt();

        Appointment appointment = manager.findAppointment(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println(appointment);
        System.out.println("\n[1] Update details");
        System.out.println("[2] Update status");
        System.out.print("Choose update type: ");

        int choice = readInt();

        if (choice == 1) {
            System.out.print("New customer name: ");
            String name = scanner.nextLine().trim();

            System.out.print("New laundry service: ");
            String service = scanner.nextLine().trim();

            System.out.print("New appointment date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();

            if (name.isEmpty() || service.isEmpty() || date.isEmpty()) {
                System.out.println("All fields are required.");
                return;
            }

            if (manager.updateAppointment(id, name, service, date)) {
                System.out.println("Appointment updated successfully.");
            } else {
                System.out.println("Appointment cannot be updated.");
            }

        } else if (choice == 2) {
            System.out.println("[1] Scheduled");
            System.out.println("[2] In Progress");
            System.out.println("[3] Completed");
            System.out.print("Choose new status: ");

            int statusChoice = readInt();
            String status;

            switch (statusChoice) {
                case 1:
                    status = "Scheduled";
                    break;
                case 2:
                    status = "In Progress";
                    break;
                case 3:
                    status = "Completed";
                    break;
                default:
                    System.out.println("Invalid status choice.");
                    return;
            }

            if (manager.updateStatus(id, status)) {
                System.out.println("Appointment status updated.");
            } else {
                System.out.println("Appointment cannot be updated.");
            }

        } else {
            System.out.println("Invalid update choice.");
        }
    }

    private void cancelAppointment() {
        System.out.print("Enter appointment ID to cancel: ");
        int id = readInt();

        if (manager.cancelAppointment(id)) {
            System.out.println("Appointment cancelled successfully.");
        } else {
            System.out.println(
                    "Appointment not found or cannot be cancelled.");
        }
    }

    private int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
