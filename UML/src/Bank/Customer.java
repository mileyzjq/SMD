package Bank;

public class Customer {

    private String name;
    private int ticketId;

    public Customer(String name, int ticketId) {
        this.name = name;
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }
}
