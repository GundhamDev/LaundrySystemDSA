
package dsa;

import backend.Appointment;
import java.util.LinkedList;

/*A linked list implementation for managing a collection of appointments.*/
public class AppointmentLinkedList {
    private final LinkedList<Appointment> appointments;

    /*Constructor for the AppointmentLinkedList class. 
      Initializes an empty linked list to store appointments.*/
    public AppointmentLinkedList() {
        appointments = new LinkedList<>();
    }

    /*Adds a new appointment to the linked list.*/
    public void add(Appointment appointment) {
        appointments.add(appointment);
    }

    /*Retrieves an appointment at a specific index in the linked list.*/
    public Appointment get(int index) {
        return appointments.get(index);
    }

    /*Removes a specific appointment from the linked list. 
      Returns true if the appointment was successfully removed, false otherwise.*/
    public boolean remove(Appointment appointment) {
        return appointments.remove(appointment);
    }

    /*Returns the number of appointments currently stored in the linked list.*/
    public int size() {
        return appointments.size();
    }

    /*Checks if the linked list of appointments is empty. 
      Returns true if there are no appointments, false otherwise.*/
    public boolean isEmpty() {
        return appointments.isEmpty();
    }
}