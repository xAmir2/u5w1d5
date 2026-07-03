package amirka.u5w1d5.exceptions;

public class BuildingNotFoundEx extends RuntimeException {
    public BuildingNotFoundEx(Long id) {
        super("Building with ID " + id + "was not found.");
    }
}
