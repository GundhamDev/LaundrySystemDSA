
package dsa;

import backend.Appointment;

public class AppointmentSearch {

    public static Appointment searchById(
            AppointmentLinkedList appointments, int id) {

        // Linear search: check each appointment until the ID matches.
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getAppointmentId() == id) {
                return appointment;
            }
        }

        return null;
    }
}
