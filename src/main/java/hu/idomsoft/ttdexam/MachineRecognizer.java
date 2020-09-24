package hu.idomsoft.ttdexam;

public class MachineRecognizer {

    public MachineType recognize(String ticketCode) {
        if (ticketCode.contains("xxx")) {
            return MachineType.METRO;
        }
        if (ticketCode.startsWith("9")) {
            return MachineType.NIGHTLY;
        }
        return MachineType.OTHER;
    }
}
