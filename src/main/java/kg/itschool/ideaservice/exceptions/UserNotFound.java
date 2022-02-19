package kg.itschool.ideaservice.exceptions;

public class UserNotFound extends RuntimeException {
    //пользователь не найден
    public UserNotFound(String message){
        super(message);
    }
}
