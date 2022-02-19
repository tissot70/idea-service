package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.UserRepo;
import kg.itschool.ideaservice.exceptions.CodeDoesNotMatch;
import kg.itschool.ideaservice.exceptions.UserAlreadyExist;
import kg.itschool.ideaservice.mappers.UserMapper;
import kg.itschool.ideaservice.models.dto.UserConfirmDTO;
import kg.itschool.ideaservice.models.dto.UserDTO;
import kg.itschool.ideaservice.models.dto.UserResponse;
import kg.itschool.ideaservice.models.entites.User;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String save(UserDTO userDTO) {
        boolean exist = userRepo.existsByPhone(userDTO.getPhone());
        if (exist){
                throw new UserAlreadyExist("такой пользователь уже есть");
        }
        User user =UserMapper.INSTANCE.userDToToUser(userDTO);
        int randomCode = 999 + (int)(Math.random() * ((9999 - 999) + 1));
        user.setCode(String.valueOf(randomCode));
        user.setActivated(false);
        user.setAddDate(LocalDate.now());
        user =userRepo.saveAndFlush(user);
        return "ваш код подтверждения-"+user.getCode();
    }

    @Override
    public String confirm(UserConfirmDTO userConfirmDTO) {
        User user = userRepo.findByPhone(userConfirmDTO.getPhone());
        if (!user.getCode().equals(userConfirmDTO.getCode())){
            throw new CodeDoesNotMatch("код не совпадает");
        }
        user.setActivated(true);
        userRepo.saveAndFlush(user);
        return "регистрация прошла успешно";
    }

    @Override
    public UserResponse findByPhoneNumber(String phone) {
        return UserMapper.INSTANCE.userToUserResponse(userRepo.findByPhone(phone));
    }
}
