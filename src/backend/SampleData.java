
package backend;

// The SampleData class is responsible for loading sample appointment data into the system.
public class SampleData {

        // This method loads sample appointments into the provided AppointmentManager instance.
    public static void load(AppointmentManager manager) {

        manager.createAppointment(
                "Aga Milagroso", "Wash and Fold", "2026-10-26");

        manager.createAppointment(
                "John Bernard Flores", "Dry Cleaning", "2026-10-2");

        manager.createAppointment(
                "Reymar Pascual", "Wash and Iron", "2026-10-19");
        
        manager.createAppointment(
                "Odie James Mangahas", "Wash", "2026-10-11");
        
        manager.createAppointment(
                "Rein Gerona", "Wash and Fold", "2026-10-15");

    }
}