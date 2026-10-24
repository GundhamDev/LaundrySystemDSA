
package backend;

import dsa.AppointmentLinkedList;
import dsa.AppointmentSearch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AppointmentManager {
    private final AppointmentLinkedList appointments;
    private final Map<Integer, Appointment> appointmentMap;
    private final Set<Integer> appointmentIds;

    private int nextId = 1;

    public AppointmentManager() {
        appointments = new AppointmentLinkedList();
        appointmentMap = new HashMap<>();
        appointmentIds = new HashSet<>();
    }

    // CREATE: Add a new appointment.
    public Appointment createAppointment(
            String customerName, String service, String date) {

        int id = nextId++;

        Appointment appointment =
                new Appointment(id, customerName, service, date);

        appointments.add(appointment);
        appointmentMap.put(id, appointment);
        appointmentIds.add(id);

        return appointment;
    }

    // READ: Display all appointment records.
    public void viewAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("------------------------");
            System.out.println(appointments.get(i));
        }

        System.out.println("------------------------");
    }

    // READ: Find one appointment using its ID.
    public Appointment findAppointment(int id) {
        // HashMap lookup for fast ID-based retrieval.
        return appointmentMap.get(id);
    }

    // READ: Alternative lookup using linear search.
    public Appointment linearSearchAppointment(int id) {
        return AppointmentSearch.searchById(appointments, id);
    }

    // UPDATE: Change an appointment's details.
    public boolean updateAppointment(
            int id, String customerName,
            String service, String date) {

        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            return false;
        }

        if (appointment.getStatus().equals("Cancelled")
                || appointment.getStatus().equals("Completed")) {
            return false;
        }

        appointment.setCustomerName(customerName);
        appointment.setService(service);
        appointment.setAppointmentDate(date);

        return true;
    }

    // UPDATE: Change the appointment status.
    public boolean updateStatus(int id, String status) {
        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            return false;
        }

        if (appointment.getStatus().equals("Cancelled")
                || appointment.getStatus().equals("Completed")) {
            return false;
        }

        if (!status.equalsIgnoreCase("Scheduled")
                && !status.equalsIgnoreCase("In Progress")
                && !status.equalsIgnoreCase("Completed")) {
            return false;
        }

        appointment.setStatus(status);
        return true;
    }

    // DELETE/CANCEL: Retain the record but mark it cancelled.
    public boolean cancelAppointment(int id) {
        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            return false;
        }

        if (appointment.getStatus().equals("Cancelled")
                || appointment.getStatus().equals("Completed")) {
            return false;
        }

        appointment.setStatus("Cancelled");
        return true;
    }

    public boolean appointmentExists(int id) {
        return appointmentIds.contains(id);
    }
}
