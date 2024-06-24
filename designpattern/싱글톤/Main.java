package designpattern.싱글톤;

public class Main {
    public static void main(String[] args) {
        TicketMaker ticketMaker1 = TicketMaker.getInstance();
        TicketMaker ticketMaker2 = TicketMaker.getInstance();


        int ticket = ticketMaker1.getTicket();
        System.out.println(ticket);
        ticketMaker1.getNextTicketNumber();
        int ticket2 = ticketMaker2.getTicket();
        System.out.println(ticket2);



    }
}
