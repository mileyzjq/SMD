package Bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TicketMachine {
    private Queue<Customer> customers = new LinkedList<>();
    private Queue<VIPCustomer> VIPcustomers = new LinkedList<>();
    private ArrayList<Window> windows = new ArrayList<>();
    private int ticket = 1;

    public void addWindow(int id, boolean isVIP) {
        Window w = new Window(id, isVIP, this);
        windows.add(w);
    }

    public void getTicket(String type) {
        if(type.equals("VIP")) {
            VIPCustomer vip = new VIPCustomer("vip "+ticket, ticket);
            customers.offer(vip);
            VIPcustomers.offer(vip);
        } else {
            Customer customer = new Customer("customer", ticket);
            customers.offer(customer);
        }
        ticket++;
    }

    public void sentToWindow(Window w) {
        //Window w = this.windows.get(index);
        if(w.isVIPWindow()) {
            if(!VIPcustomers.isEmpty()) {
                VIPCustomer vip = VIPcustomers.poll();
                System.out.println(vip.getName() + " go to Window " + w.getIndex());
            }
        } else {
            Customer p = customers.poll();
            if (!VIPcustomers.isEmpty() && p.getName().equals(VIPcustomers.peek().getName())) {
                VIPcustomers.poll();
                System.out.println(p.getName() + " go to Window " + w.getIndex());
            } else {
                System.out.println(p.getName() + " go to Window " + w.getIndex());
            }
        }
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine();
        machine.addWindow(1, false);
        machine.addWindow(2, true);
        machine.addWindow(3, false);

        machine.getTicket("VIP");
        machine.getTicket("NVIP");
        machine.getTicket("NVIP");
        machine.getTicket("NVIP");
        machine.getTicket("VIP");

        for(int i=0; i<3; i++) {
            machine.getWindows().get(i).callCustomer();
        }
    }
}
