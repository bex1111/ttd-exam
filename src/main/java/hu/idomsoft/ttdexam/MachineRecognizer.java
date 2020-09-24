package hu.idomsoft.ttdexam;

public class MachineRecognizer {
    public String recognize(String ticketCode) {
        if (ticketCode.contains("xxx")) {
            return "M";
        }
        if (ticketCode.startsWith("9")) {
            return "N";
        }
        return "O";
    }
}
