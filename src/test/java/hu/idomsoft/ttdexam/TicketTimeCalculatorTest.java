package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketTimeCalculatorTest {

    private static final DateTimeFormatter TEST_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private TicketTimeCalculator ticketTimeCalculator;

    @Before
    public void setUp() {
        ticketTimeCalculator = new TicketTimeCalculator();
    }

    @Test
    public void calculateMetroDate() {
        String testDate = "2019-11-28 13:05";
        Assert.assertEquals(LocalDateTime.parse(testDate, TEST_DATE_TIME_FORMATTER), ticketTimeCalculator.calculate("0643xxx911281305"));
    }

    @Test
    public void calculateOtherMachineDate() {
        String testDate = "2020-12-04 09:56";
        Assert.assertEquals(LocalDateTime.parse("2020-12-04 09:56", TEST_DATE_TIME_FORMATTER), ticketTimeCalculator.calculate("5151312040956"));
    }


}