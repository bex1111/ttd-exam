package hu.idomsoft.ttdexam;

import java.time.LocalDateTime;

public class TicketValidator {

    private static final int METRO_TRAVEL_TIME = 80;
    private static final int NIGHTLY_TRAVEL_TIME = 120;

    public boolean isValid(LocalDateTime validationDate, String ticketCode) {
        MachineType machineType = new MachineRecognizer().recognize(ticketCode);
        LocalDateTime calculateTicketTime = new TicketTimeCalculator().calculate(ticketCode, machineType);
        if (machineType.equals(MachineType.METRO)) {
            return !calculateTicketTime.minusMinutes(METRO_TRAVEL_TIME).isAfter(validationDate);
        }
        return !calculateTicketTime.minusMinutes(NIGHTLY_TRAVEL_TIME).isAfter(replaceNotNecessaryYear(validationDate));
    }

    private LocalDateTime replaceNotNecessaryYear(LocalDateTime validationDate) {
        return validationDate.withYear(LocalDateTime.now().getYear());
    }
}
