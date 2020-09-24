package hu.idomsoft.ttdexam;

import java.time.LocalDateTime;

public class TicketValidator {

    private static final int METRO_TRAVEL_TIME = 80;

    public boolean validate(LocalDateTime validationDate, String ticketCode) {
        return new TicketTimeCalculator().calculate(ticketCode).minusMinutes(METRO_TRAVEL_TIME).isBefore(validationDate);
    }
}
