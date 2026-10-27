
package backend;

/*This class represents an appointment in the system. 
  It contains details such as the appointment ID, customer name, service type, appointment date, and status.*/
public class Appointment {
    private int appointmentId;
    private String customerName;
    private String service;
    private String appointmentDate;
    private String status;

    //This is the constructor for the Appointment class. It initializes the appointment with the provided details and sets the default status to "Scheduled".
    public Appointment(int appointmentId, String customerName,
                       String service, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.customerName = customerName;
        this.service = service;
        this.appointmentDate = appointmentDate;
        this.status = "Scheduled";
    }

    //This method returns the unique ID of the appointment.
    public int getAppointmentId() {
        return appointmentId;
    }

    //This method sets the unique ID of the appointment.
    public String getCustomerName() {
        return customerName;
    }

    //This method returns the name of the customer associated with the appointment.
    public String getService() {
        return service;
    }

    //This method returns the type of service associated with the appointment.
    public String getAppointmentDate() {
        return appointmentDate;
    }

    //This method returns the date of the appointment.
    public String getStatus() {
        return status;
    }

    //This method returns the current status of the appointment (e.g., Scheduled, In Progress, Completed, Cancelled).
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //This method sets the name of the customer associated with the appointment.
    public void setService(String service) {
        this.service = service;
    }

    //This method sets the type of service associated with the appointment.
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    //This method sets the date of the appointment.
    public void setStatus(String status) {
        this.status = status;
    }

    //This method sets the current status of the appointment (e.g., Scheduled, In Progress, Completed, Cancelled).
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId
                + "\nCustomer: " + customerName
                + "\nService: " + service
                + "\nDate: " + appointmentDate
                + "\nStatus: " + status;
    }
}