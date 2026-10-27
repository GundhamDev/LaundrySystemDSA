
package app;

import backend.AppointmentManager;
import backend.SampleData;
import cli.AppointmentMenu;


/*The Main class serves as the entry point for the application. 
  It initializes the AppointmentManager, loads sample data, and starts the appointment menu.*/
public class Main {
    public static void main(String[] args) {
        // Create an instance of AppointmentManager to manage appointments.
        AppointmentManager manager = new AppointmentManager();

        // Load sample appointments before starting the menu.
        SampleData.load(manager);

        // This is the appointment menu that will be displayed to the user.
        AppointmentMenu menu = new AppointmentMenu(manager);
        menu.showMenu();
    }
}