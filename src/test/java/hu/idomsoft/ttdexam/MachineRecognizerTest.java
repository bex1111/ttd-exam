package hu.idomsoft.ttdexam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MachineRecognizerTest {

    private MachineRecognizer machineRecognizer;

    @Before
    public void setUp() {
        machineRecognizer = new MachineRecognizer();
    }

    @Test
    public void metroTest() {
        Assert.assertEquals(MachineType.METRO, machineRecognizer.recognize("0643xxx911281305"));
    }

    @Test
    public void nightlyBusTest() {
        Assert.assertEquals(MachineType.NIGHTLY, machineRecognizer.recognize("91451312040956"));
    }

    @Test
    public void otherMachineTest() {
        Assert.assertEquals(MachineType.OTHER, machineRecognizer.recognize("5151312040956"));
        Assert.assertEquals(MachineType.OTHER, machineRecognizer.recognize("58151312040956"));
    }
}