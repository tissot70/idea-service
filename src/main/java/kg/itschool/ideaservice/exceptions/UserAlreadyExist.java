package kg.itschool.ideaservice.exceptions;

public class UserAlreadyExist extends Exception {
    // такой пользователь уже сущ
    public UserAlreadyExist (String message){
        super(message);
    }
}
