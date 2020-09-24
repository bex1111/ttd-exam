package hu.idomsoft.ttdexam;

import java.time.LocalDateTime;

public class TicketValidator {

    private static final int METRO_TRAVEL_TIME = 80;
    public static final int NIGHTLY_TRAVEL_TIME = 120;

    public boolean isValid(LocalDateTime validationDate, String ticketCode) {
        if (new MachineRecognizer().recognize(ticketCode).equals("M")) {
            return !new TicketTimeCalculator().calculate(ticketCode).minusMinutes(METRO_TRAVEL_TIME).isAfter(validationDate);
        }
        return !new TicketTimeCalculator().calculate(ticketCode).minusMinutes(NIGHTLY_TRAVEL_TIME).isAfter(validationDate.withYear(LocalDateTime.now().getYear()));
    }
}
