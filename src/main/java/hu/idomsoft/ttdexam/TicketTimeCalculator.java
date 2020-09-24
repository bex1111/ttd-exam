package hu.idomsoft.ttdexam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketTimeCalculator {

    public static final String METRO_DATE_PATTERN = "yMMddHHmm";
    public static final int METRO_DATE_BEGIN_INDEX = 7;

    public TicketTimeCalculator() {

    }

    public LocalDateTime calculate(String ticketCode) {
        String machineType = new MachineRecognizer().recognize(ticketCode);
        if (machineType.equals("M")) {
            LocalDateTime ticketDate = LocalDateTime.parse(ticketCode.substring(METRO_DATE_BEGIN_INDEX), DateTimeFormatter.ofPattern(METRO_DATE_PATTERN));
            int lastDigitOfCurrentYear = LocalDateTime.now().getYear() % 10;
            return ticketDate.plusYears(LocalDateTime.now().minusYears(lastDigitOfCurrentYear).getYear() - 10);
        }
        return null;
    }
}
