package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketTimeCalculatorTest {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void calculateMetroDate() {
        TicketTimeCalculator ticketTimeCalculator = new TicketTimeCalculator();
        Assert.assertEquals(LocalDateTime.parse("2019-11-28 13:05", DATE_TIME_FORMATTER), ticketTimeCalculator.calculate("0643xxx911281305"));
    }

    @Test
    public void calculateOtherMachineDate() {
        TicketTimeCalculator ticketTimeCalculator = new TicketTimeCalculator();
        Assert.assertEquals(LocalDateTime.parse("2020-12-04 09:56", DATE_TIME_FORMATTER), ticketTimeCalculator.calculate("5151312040956"));
    }


}