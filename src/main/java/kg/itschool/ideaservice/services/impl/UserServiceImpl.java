package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.UserRepo;
import kg.itschool.ideaservice.exceptions.UserAlreadyExist;
import kg.itschool.ideaservice.mappers.UserMapper;
import kg.itschool.ideaservice.models.dto.UserConfirmDTO;
import kg.itschool.ideaservice.models.dto.UserDTO;
import kg.itschool.ideaservice.models.entites.User;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String save(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDToToUser(userDTO);
        try {
            if (Objects.isNull(userRepo.findByPhoneAndName(user.getPhone(),user.getName()))){
                user.setActivated(false);
                user.setAddDate(LocalDate.now());
                user = userRepo.save(user);
            }else {
                throw new UserAlreadyExist("такой пользователь уже есть");
            }
        } catch (UserAlreadyExist e) {
            e.getMessage();
        }
        int randomCode = 999 + (int)(Math.random() * ((9999 - 999) + 1));
        return "ваш код подтверждения"+String.valueOf(randomCode);
    }

    /*@Override
    public String confirm(UserConfirmDTO userConfirmDTO) {
        return null;
    }*/
}
