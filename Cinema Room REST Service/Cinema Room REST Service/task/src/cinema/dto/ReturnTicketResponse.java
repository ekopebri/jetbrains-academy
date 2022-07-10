package cinema.dto;

import cinema.Seat;

public class ReturnTicketResponse {
    private Seat returned_ticket;

    public ReturnTicketResponse(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public ReturnTicketResponse() {
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
