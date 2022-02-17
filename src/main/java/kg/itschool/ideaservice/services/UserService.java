package kg.itschool.ideaservice.services;

import kg.itschool.ideaservice.models.dto.UserConfirmDTO;
import kg.itschool.ideaservice.models.dto.UserDTO;

public interface UserService {
    String save(UserDTO userDTO);

    //String confirm(UserConfirmDTO userConfirmDTO);
}
