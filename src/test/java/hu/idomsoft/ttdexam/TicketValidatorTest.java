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
    public void validMetroTicketTest() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(ticketValidator.isValid(testDate, "0643xxx911281425"));
    }

    @Test
    public void invalidMetroTicketTest() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertFalse(ticketValidator.isValid(testDate, "0643xxx911281426"));
    }

    @Test
    public void validNightlyTicketTest() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 01:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(ticketValidator.isValid(testDate, "91451311280305"));
    }

    @Test
    public void invalidNightlyTicketTest() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 01:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertFalse(ticketValidator.isValid(testDate, "91451311280306"));
    }

    @Test
    public void validOtherTicketTest() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(ticketValidator.isValid(testDate, "51451311281605"));
    }

}
