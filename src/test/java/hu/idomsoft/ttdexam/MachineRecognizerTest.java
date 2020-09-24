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

    @Test
    public void otherMachineTest() {
        MachineRecognizer machineRecognizer = new MachineRecognizer();
        Assert.assertEquals("O", machineRecognizer.recognize("5151312040956"));
        Assert.assertEquals("O", machineRecognizer.recognize("58151312040956"));
    }
}