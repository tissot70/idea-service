package kg.itschool.ideaservice.mappers;


import kg.itschool.ideaservice.models.dto.UserDTO;
import kg.itschool.ideaservice.models.dto.UserResponse;
import kg.itschool.ideaservice.models.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDToToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);

    UserResponse userToUserResponse(User user);
    User userResponseToUser(UserResponse userResponse);
}
