
package dsa;

import backend.Appointment;

public class AppointmentSearch {

    /*
     * DSA CONCEPT: Linear Search
     *
     * USED BY:
     * - Finding an appointment by reference number.
     *
     * HOW IT WORKS:
     * - Checks each appointment from beginning to end.
     * - Stops when the reference number matches.
     * - Returns null if no matching appointment exists.
     *
     * TIME COMPLEXITY: O(n)
     */

    public static Appointment linearSearch(
            AppointmentLinkedList appointments,
            String referenceNumber) {

        // Traverse the linked list one appointment at a time.
        Appointment current = appointments.find(referenceNumber);

        return current;
    }
}
