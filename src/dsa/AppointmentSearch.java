
package dsa;

import backend.Appointment;

/*The AppointmentSearch class provides a method to search for an appointment 
  by its unique ID within a linked list of appointments. 
  It performs a linear search through the list and returns the 
  matching appointment if found, or null if not found.*/
public class AppointmentSearch {

    /* Searches for an appointment by its unique ID within a linked list of appointments. 
       Returns the matching appointment if found, or null if not found. */
    public static Appointment searchById(AppointmentLinkedList appointments, int id) {

        /* Linear search: check each appointment until the ID matches. */
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getAppointmentId() == id) {
                return appointment;
            }
        }

        return null;
    }
}
