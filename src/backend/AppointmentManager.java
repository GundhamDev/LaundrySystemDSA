
package backend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import dsa.AppointmentLinkedList;
import dsa.AppointmentQueue;
import dsa.AppointmentSearch;
import dsa.AppointmentSort;
import dsa.AppointmentStack;

public class AppointmentManager {

    /*
     * BACKEND: Appointment Management
     *
     * DSA INTEGRATION:
     * - Linked List: stores and traverses appointments.
     * - HashMap: looks up appointments by reference number.
     * - HashSet: prevents duplicate reference numbers.
     * - Linear Search: finds appointments in the linked list.
     * - Bubble Sort: sorts appointments by date.
     * - Queue: tracks appointments in arrival order (FIFO).
     * - Stack: tracks recently created appointments (LIFO).
     */

    private final AppointmentLinkedList appointments;
    private final Map<String, Appointment> appointmentMap;
    private final Set<String> referenceNumbers;
    private final AppointmentQueue appointmentQueue;
    private final AppointmentStack appointmentStack;

    public AppointmentManager() {
        appointments = new AppointmentLinkedList();
        appointmentMap = new HashMap<>();
        referenceNumbers = new HashSet<>();
        appointmentQueue = new AppointmentQueue();
        appointmentStack = new AppointmentStack();
    }

    private String normalizeReference(String referenceNumber) {
        return referenceNumber.trim().toUpperCase(Locale.ROOT);
    }

    // CREATE: Add an appointment to all relevant data structures.
    public boolean createAppointment(Appointment appointment) {
        String reference =
                normalizeReference(appointment.getReferenceNumber());

        if (reference.isEmpty()) {
            System.out.println("Reference number cannot be empty.");
            return false;
        }

        if (referenceNumbers.contains(reference)) {
            System.out.println("Reference number already exists.");
            return false;
        }

        appointments.add(appointment);
        appointmentMap.put(reference, appointment);
        referenceNumbers.add(reference);
        appointmentQueue.enqueue(appointment);
        appointmentStack.push(appointment);

        System.out.println("Appointment created successfully.");
        return true;
    }

    // READ: Display appointments in insertion order.
    public void viewAppointments() {
        appointments.display();
    }

    // READ: Find an appointment using Linear Search.
    public Appointment searchAppointment(String referenceNumber) {
        return AppointmentSearch.linearSearch(
                appointments,
                referenceNumber.trim()
        );
    }

    // READ: Display appointments sorted by date using Bubble Sort.
    public void viewAppointmentsSortedByDate() {
        List<Appointment> sortedAppointments =
                AppointmentSort.bubbleSortByDate(appointments.toList());

        if (sortedAppointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println("\n--- APPOINTMENTS SORTED BY DATE ---");

        for (Appointment appointment : sortedAppointments) {
            System.out.println("------------------------------");
            System.out.println(appointment);
        }

        System.out.println("------------------------------");
    }

    // QUEUE: Display appointments in arrival order.
    public void viewAppointmentQueue() {
        appointmentQueue.displayQueue();
    }

    // STACK: Display recent appointments, newest first.
    public void viewRecentAppointments() {
        appointmentStack.displayStack();
    }

    // UPDATE: Modify appointment details using the HashMap.
    public boolean updateAppointment(
            String referenceNumber,
            String customerName,
            String appointmentDate,
            String appointmentTime,
            String laundryService) {

        String reference = normalizeReference(referenceNumber);
        Appointment appointment = appointmentMap.get(reference);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return false;
        }

        appointment.setCustomerName(customerName);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setLaundryService(laundryService);

        System.out.println("Appointment updated successfully.");
        return true;
    }

    // DELETE/CANCEL: Remove the appointment from all data structures.
    public boolean cancelAppointment(String referenceNumber) {
        String reference = normalizeReference(referenceNumber);
        Appointment appointment = appointmentMap.get(reference);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return false;
        }

        appointments.remove(reference);
        appointmentMap.remove(reference);
        referenceNumbers.remove(reference);
        appointmentQueue.remove(reference);
        appointmentStack.remove(reference);

        System.out.println("Appointment cancelled successfully.");
        return true;
    }
}