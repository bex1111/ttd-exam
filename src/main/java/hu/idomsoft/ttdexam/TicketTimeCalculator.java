package hu.idomsoft.ttdexam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketTimeCalculator {

    public static final String METRO_DATE_PATTERN = "yMMddHHmm";
    public static final String OTHER_DATE_PATTERN = "yyyyMMddHHmm";
    public static final int METRO_DATE_BEGIN_INDEX = 7;
    public static final int OTHER_MACHINE_TIME_INDEX_OFFSET = 8;

    public TicketTimeCalculator() {
    }

    public LocalDateTime calculate(String ticketCode) {
        String machineType = new MachineRecognizer().recognize(ticketCode);
        if (machineType.equals("M")) {
            return generateMetroDate(ticketCode);
        } else {
            return generateOtherMachineDate(ticketCode);
        }
    }

    private LocalDateTime generateOtherMachineDate(String ticketCode) {
        LocalDateTime ticketDate = LocalDateTime.parse(generateOtherMachineDateText(ticketCode), DateTimeFormatter.ofPattern(OTHER_DATE_PATTERN));
        return ticketDate;
    }

    private LocalDateTime generateMetroDate(String ticketCode) {
        LocalDateTime ticketDate = LocalDateTime.parse(ticketCode.substring(METRO_DATE_BEGIN_INDEX), DateTimeFormatter.ofPattern(METRO_DATE_PATTERN));
        int lastDigitOfCurrentYear = LocalDateTime.now().getYear() % 10;
        return ticketDate.plusYears(LocalDateTime.now().minusYears(lastDigitOfCurrentYear).getYear() - 10);
    }

    private String generateOtherMachineDateText(String ticketCode) {
        return LocalDateTime.now().getYear() + ticketCode.substring(ticketCode.length() - OTHER_MACHINE_TIME_INDEX_OFFSET);
    }
}
