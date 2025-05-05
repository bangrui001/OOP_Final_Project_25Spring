import java.util.ArrayList;

public class Seat {
    private String seatId;
    private int capacity;
    private boolean isReservable;
    private ArrayList<SeatReservation> reservations;

    public Seat(String seatId, int capacity) {
        this.seatId = seatId;
        this.capacity = capacity;
        this.isReservable = true;
        this.reservations = new ArrayList<>();
    }

    public String getSeatId() {
        return seatId;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReservable() {
        return isReservable;
    }

    public void setReservable(boolean reservable) {
        this.isReservable = reservable;
    }

    public ArrayList<SeatReservation> getReservations() {
        return reservations;
    }

    public void addReservation(SeatReservation r) {
        reservations.add(r);
    }

    public boolean removeReservation(String customerName, String hour) {
        for (int i = 0; i < reservations.size(); i++) {
            SeatReservation r = reservations.get(i);
            if (r.getCustomerName().equals(customerName) && r.getHour().equals(hour)) {
                reservations.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printReservations() {
        System.out.println("Seat " + seatId + " (Capacity: " + capacity + ") reservations:");
        for (SeatReservation r : reservations) {
            System.out.println("  - " + r.getHour() + ":00 by " + r.getCustomerName());
        }
    }

    public boolean isAvailableAt(String hour) {
        if (!isReservable) return false;
        for (SeatReservation r : reservations) {
            if (r.getHour().equals(hour)) return false;
        }
        return true;
    }
}
