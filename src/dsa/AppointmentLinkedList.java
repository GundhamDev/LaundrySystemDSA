
package dsa;

import backend.Appointment;
import java.util.LinkedList;

public class AppointmentLinkedList {
    private final LinkedList<Appointment> appointments;

    public AppointmentLinkedList() {
        appointments = new LinkedList<>();
    }

    public void add(Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment get(int index) {
        return appointments.get(index);
    }

    public boolean remove(Appointment appointment) {
        return appointments.remove(appointment);
    }

    public int size() {
        return appointments.size();
    }

    public boolean isEmpty() {
        return appointments.isEmpty();
    }
}
