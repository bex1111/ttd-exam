package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketValidatorTest {

    private static final DateTimeFormatter TEST_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private TicketValidator ticketValidator;

    @Before
    public void setUp() {
        ticketValidator = new TicketValidator();
    }

    @Test
    public void validMetroTicket() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(ticketValidator.isValid(testDate, "0643xxx911281425"));
    }

    @Test
    public void invalidMetroTicket() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertFalse(ticketValidator.isValid(testDate, "0643xxx911281426"));
    }

    @Test
    public void validNightlyTicket() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 01:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(ticketValidator.isValid(testDate, "91451311280305"));
    }


}
