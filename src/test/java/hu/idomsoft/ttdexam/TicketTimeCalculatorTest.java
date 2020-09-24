package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketTimeCalculatorTest {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void validMetroTicketTest() {
        TicketTimeCalculator ticketTimeCalculator = new TicketTimeCalculator();
        Assert.assertEquals(LocalDateTime.parse("2019-11-28 13:05", DATE_TIME_FORMATTER), ticketTimeCalculator.calculate("0643xxx911281305"));

    }
}