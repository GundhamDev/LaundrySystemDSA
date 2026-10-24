
package backend;

public class SampleData {

    public static void load(AppointmentManager manager) {
        manager.createAppointment(
                "Aga Milagroso", "Wash and Fold", "2026-10-26");

        manager.createAppointment(
                "Maria Santos", "Dry Cleaning", "2026-10-27");

        manager.createAppointment(
                "Pedro Reyes", "Wash and Iron", "2026-10-28");
    }
}
