package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketValidatorTest {

    private static final DateTimeFormatter TEST_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void validMetroTicket() {
        LocalDateTime testDate = LocalDateTime.parse("2019-11-28 13:05", TEST_DATE_TIME_FORMATTER);
        Assert.assertTrue(new TicketValidator().validate(testDate, "0643xxx911281355"));
    }
}
