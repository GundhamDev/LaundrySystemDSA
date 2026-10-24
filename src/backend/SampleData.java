
package backend;

public class SampleData {

    /*
     * PURPOSE: Initial appointment data for testing.
     *
     * USED BY:
     * - Main.java during application startup.
     * - AppointmentManager to register sample appointments
     *   in the linked list, HashMap, and HashSet.
     *
     * These records are recreated each time the program starts.
     */

    public static void loadAppointments(AppointmentManager manager) {

        manager.createAppointment(
                new Appointment(
                        "LA001",
                        "Alex Santos",
                        "2026-10-25",
                        "09:00 AM",
                        "Wash and Fold",
                        "CONFIRMED"
                )
        );

        manager.createAppointment(
                new Appointment(
                        "LA002",
                        "Maria Reyes",
                        "2026-10-25",
                        "10:00 AM",
                        "Dry Cleaning",
                        "PENDING"
                )
        );

        manager.createAppointment(
                new Appointment(
                        "LA003",
                        "John Cruz",
                        "2026-10-26",
                        "01:00 PM",
                        "Wash and Fold",
                        "IN_QUEUE"
                )
        );
    }
}
