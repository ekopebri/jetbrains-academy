package cinema.utils;

import cinema.Seat;
import cinema.Ticket;

import java.util.List;

public class CinemaUtils {
    public static int getPrice(int row) {
        if (row <= 4)
            return 10;

        return 8;
    }

    public static long getCurrentIncome(List<Ticket> tickets) {
        return tickets
                .stream()
                .reduce(0, (a, b) -> a + b.getTicket().getPrice(), Integer::sum);

    };

    public static long getAvailableSeat(List<Seat> seats) {
        return seats
                .stream()
                .filter(v -> !v.isSold())
                .count();
    }
}
