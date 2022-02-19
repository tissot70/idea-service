package kg.itschool.ideaservice.exceptions;

public class UserNotActivated extends RuntimeException {
    public UserNotActivated(String message) {
        super(message);
    }
}
