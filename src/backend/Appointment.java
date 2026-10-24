
package backend;

public class Appointment {
    private int appointmentId;
    private String customerName;
    private String service;
    private String appointmentDate;
    private String status;

    public Appointment(int appointmentId, String customerName,
                       String service, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.customerName = customerName;
        this.service = service;
        this.appointmentDate = appointmentDate;
        this.status = "Scheduled";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getService() {
        return service;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId
                + "\nCustomer: " + customerName
                + "\nService: " + service
                + "\nDate: " + appointmentDate
                + "\nStatus: " + status;
    }
}
