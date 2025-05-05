public class SeatReservation {
    private String customerName;
    private String hour;

    public SeatReservation(String customerName, String hour) {
        this.customerName = customerName;
        this.hour = hour;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getHour() {
        return hour;
    }
}
