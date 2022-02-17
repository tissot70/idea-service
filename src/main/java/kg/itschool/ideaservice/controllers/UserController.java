package kg.itschool.ideaservice.controllers;

import kg.itschool.ideaservice.models.dto.UserConfirmDTO;
import kg.itschool.ideaservice.models.dto.UserDTO;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    /*@PostMapping("/confirm")
    public String confirmUserCode(@RequestBody UserConfirmDTO userConfirmDTO){
        return userService.confirm(userConfirmDTO);
    }*/
}
