
package backend;

public class Appointment {

    private String referenceNumber;
    private String customerName;
    private String appointmentDate;
    private String appointmentTime;
    private String laundryService;
    private String status;

    // Constructor: creates a new appointment
    public Appointment(
            String referenceNumber,
            String customerName,
            String appointmentDate,
            String appointmentTime,
            String laundryService,
            String status) {

        this.referenceNumber = referenceNumber;
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.laundryService = laundryService;
        this.status = status;
    }

    // Getters
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getLaundryService() {
        return laundryService;
    }

    public String getStatus() {
        return status;
    }

    // Setters: used when updating an appointment
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setLaundryService(String laundryService) {
        this.laundryService = laundryService;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Displays appointment information
    @Override
    public String toString() {
        return "Reference Number: " + referenceNumber
                + "\nCustomer Name: " + customerName
                + "\nAppointment Date: " + appointmentDate
                + "\nAppointment Time: " + appointmentTime
                + "\nLaundry Service: " + laundryService
                + "\nStatus: " + status;
    }
}
