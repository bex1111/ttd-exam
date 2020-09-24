package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Test;

public class MachineRecognizerTest {

    @Test
    public void metroTest() {
        MachineRecognizer machineRecognizer = new MachineRecognizer();
        Assert.assertEquals("M", machineRecognizer.recognize("0643xxx911281305"));
    }

    @Test
    public void nightlyBusTest() {
        MachineRecognizer machineRecognizer = new MachineRecognizer();
        Assert.assertEquals("N", machineRecognizer.recognize("91451312040956"));
    }
}