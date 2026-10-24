
package dsa;

import backend.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentLinkedList {

    /*
     * DSA CONCEPT: Singly Linked List
     *
     * USED BY:
     * - Create Appointment: adds a new appointment.
     * - View Appointments: traverses all appointments.
     * - Update Appointment: supports finding an appointment.
     * - Cancel Appointment: removes an appointment.
     * - Bubble Sort: converts appointments into a list for sorting.
     *
     * PURPOSE:
     * Demonstrates nodes, references, traversal, insertion,
     * searching, deletion, and conversion to a list.
     */

    private class Node {
        Appointment appointment;
        Node next;

        Node(Appointment appointment) {
            this.appointment = appointment;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public AppointmentLinkedList() {
        head = null;
        size = 0;
    }

    // Adds an appointment to the end of the linked list.
    public void add(Appointment appointment) {
        Node newNode = new Node(appointment);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    // Displays all appointments in their current order.
    public void display() {
        if (head == null) {
            System.out.println("No appointments found.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println("------------------------------");
            System.out.println(current.appointment);
            current = current.next;
        }

        System.out.println("------------------------------");
    }

    // Searches for an appointment by reference number.
    public Appointment find(String referenceNumber) {
        Node current = head;

        while (current != null) {
            if (current.appointment.getReferenceNumber()
                    .equalsIgnoreCase(referenceNumber)) {
                return current.appointment;
            }

            current = current.next;
        }

        return null;
    }

    // Removes an appointment by reference number.
    public boolean remove(String referenceNumber) {
        if (head == null) {
            return false;
        }

        if (head.appointment.getReferenceNumber()
                .equalsIgnoreCase(referenceNumber)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.appointment.getReferenceNumber()
                    .equalsIgnoreCase(referenceNumber)) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /*
     * Returns appointments as a standard Java List.
     *
     * USED BY:
     * - AppointmentSort for Bubble Sort.
     *
     * The original linked list remains unchanged.
     */
    public List<Appointment> toList() {
        List<Appointment> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.appointment);
            current = current.next;
        }

        return list;
    }

    // Returns the number of appointments in the linked list.
    public int size() {
        return size;
    }

    // Checks whether the linked list is empty.
    public boolean isEmpty() {
        return head == null;
    }
}
