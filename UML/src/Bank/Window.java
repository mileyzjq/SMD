package Bank;

public class Window {

    public boolean isVIPWindow() {
        return isVIPWindow;
    }

    private boolean isVIPWindow;

    public int getIndex() {
        return this.index;
    }

    private int index;
    private TicketMachine machine;

    public Window(int index, boolean isVIPWindow, TicketMachine machine) {
        this.index = index;
        this.isVIPWindow = isVIPWindow;
        this.machine = machine;
    }

    public void callCustomer() {
        System.out.println("window "+ index + "is empty..");
        machine.sentToWindow(this);
    }
}
