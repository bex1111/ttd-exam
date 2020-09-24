package hu.idomsoft.ttdexam;

public class MachineRecognizer {
    public String recognize(String ticketCode) {
        if (ticketCode.contains("xxx")) {
            return "M";
        }
        return null;
    }
}
