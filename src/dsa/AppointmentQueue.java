
package dsa;

import backend.Appointment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AppointmentQueue {

    /*
     * DSA: Queue (FIFO)
     * USED BY: Create and cancel appointments; view arrival order.
     * FIFO = First In, First Out.
     */

    private final Queue<Appointment> queue = new LinkedList<>();

    public void enqueue(Appointment appointment) {
        queue.offer(appointment);
    }

    public Appointment dequeue() {
        return queue.poll();
    }

    public Appointment peek() {
        return queue.peek();
    }

    // Removes a cancelled appointment from anywhere in the queue.
    public boolean remove(String referenceNumber) {
        Iterator<Appointment> iterator = queue.iterator();

        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();

            if (appointment.getReferenceNumber()
                    .equalsIgnoreCase(referenceNumber)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("The appointment queue is empty.");
            return;
        }

        System.out.println("\n--- APPOINTMENT QUEUE (FIFO) ---");

        for (Appointment appointment : queue) {
            System.out.println(
                    appointment.getReferenceNumber()
                    + " - " + appointment.getCustomerName()
            );
        }
    }
}