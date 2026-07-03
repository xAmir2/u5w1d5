package amirka.u5w1d5.exceptions;

public class WorkstationNotFoundEx extends RuntimeException {
    public WorkstationNotFoundEx(String code) {
        super("Workstation with this code: " + code + "was not found.");
    }
}
