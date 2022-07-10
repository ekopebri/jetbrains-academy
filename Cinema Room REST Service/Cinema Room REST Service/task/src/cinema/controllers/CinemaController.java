package cinema.controllers;

import cinema.Seat;
import cinema.Ticket;
import cinema.dto.*;
import cinema.exception.AlreadyPurchasedException;
import cinema.exception.WrongPasswordException;
import io.micrometer.core.lang.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static cinema.utils.CinemaUtils.*;

@RestController
public class CinemaController {
    private static int rows = 9;
    private static int columns = 9;
    private static List<Seat> seats = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats.add(new Seat(i+1, j+1, getPrice(i+1)));
            }
        }
    }

    @GetMapping("/seats")
    public Map<String, Object> getSeats() {
        Map<String, Object> response = new HashMap<>();
        response.put("total_rows", rows);
        response.put("total_columns", columns);
        response.put("available_seats", seats);
        return response;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Object> buyTicket(@RequestBody BuyTicket request) {
        try {
            Seat seat = seats
                    .stream()
                    .filter(v -> v.getRow() == request.getRow() && v.getColumn() == request.getColumn())
                    .findFirst().orElse(null);

            if (seat == null) {
                throw new IndexOutOfBoundsException("The number of a row or a column is out of bounds!");
            }

            if (seat.isSold()) {
                throw new AlreadyPurchasedException("The ticket has been already purchased!");
            }

            seat.setSold(true);
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), seat);
            tickets.add(ticket);

            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (AlreadyPurchasedException exception) {
            return new ResponseEntity<>(new SoldResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (IndexOutOfBoundsException exception) {
            return new ResponseEntity<>(new SoldResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return")
    public ResponseEntity<Object> returnTicket(@RequestBody ReturnTicketRequest request) {
        try {

        Ticket ticket = tickets
                .stream()
                .filter(v -> v.getToken().equals(request.getToken()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Seat seat = ticket.getTicket();
        seat.setSold(false);
        tickets.remove(ticket);

        return new ResponseEntity<>(new ReturnTicketResponse(seat), HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(new SoldResponse("Wrong token!"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/stats")
    public ResponseEntity<Object> checkStatistic(@RequestParam @Nullable String password) {
        try {
            if (password == null || !password.equals("super_secret" )) {
                throw new WrongPasswordException("The password is wrong!");
            }

            StatisticResponse response = new StatisticResponse();
            response.setCurrent_income(getCurrentIncome(tickets));
            response.setNumber_of_available_seats(getAvailableSeat(seats));
            response.setNumber_of_purchased_tickets(seats.size() - response.getNumber_of_available_seats());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (WrongPasswordException exception) {
            return new ResponseEntity<>(new SoldResponse(exception.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
