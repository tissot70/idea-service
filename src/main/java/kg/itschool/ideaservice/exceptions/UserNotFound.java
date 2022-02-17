package kg.itschool.ideaservice.exceptions;

public class UserNotFound extends Exception {
    //пользователь не найден
    public UserNotFound(String message){
        super(message);
    }
}
