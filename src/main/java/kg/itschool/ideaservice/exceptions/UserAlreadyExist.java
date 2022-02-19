package kg.itschool.ideaservice.exceptions;

public class UserAlreadyExist extends RuntimeException {
    // такой пользователь уже сущ
    public UserAlreadyExist (String message){
        super(message);
    }
}
