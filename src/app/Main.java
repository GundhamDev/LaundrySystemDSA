
package app;

import backend.AppointmentManager;
import backend.SampleData;
import cli.AppointmentMenu;

public class Main {
    public static void main(String[] args) {
        AppointmentManager manager = new AppointmentManager();

        // Load sample appointments before starting the menu.
        SampleData.load(manager);

        AppointmentMenu menu = new AppointmentMenu(manager);
        menu.showMenu();
    }
}
