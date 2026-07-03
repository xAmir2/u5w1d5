package amirka.u5w1d5.exceptions;

public class UserNotFoundEx extends RuntimeException {
    public UserNotFoundEx(String username) {
        super("User with username " + username + " was not found.");
    }
}
