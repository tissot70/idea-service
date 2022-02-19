package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.IdeaRepo;
import kg.itschool.ideaservice.exceptions.UserNotActivated;
import kg.itschool.ideaservice.exceptions.UserNotFound;
import kg.itschool.ideaservice.mappers.IdeaMapper;
import kg.itschool.ideaservice.mappers.UserMapper;
import kg.itschool.ideaservice.models.dto.IdeaDTO;
import kg.itschool.ideaservice.models.dto.UserResponse;
import kg.itschool.ideaservice.models.entites.Idea;
import kg.itschool.ideaservice.services.IdeaService;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class IdeaServiceImpl implements IdeaService {

    private IdeaRepo ideaRepo;
    private UserService userService;

    public IdeaServiceImpl(IdeaRepo ideaRepo, UserService userService) {
        this.ideaRepo = ideaRepo;
        this.userService = userService;
    }

    @Override
    public IdeaDTO save(IdeaDTO ideaDTO) {
        UserResponse userResponse= userService.findByPhoneNumber(ideaDTO.getPhone());
        if (Objects.isNull(userResponse)){
            throw new UserNotFound("пользователь:"+ideaDTO.getPhone()+"\t не найден");
        }
        if (!userResponse.isActivated()){
            throw new UserNotActivated("пользователь не актвирован");
        }
        Idea idea = IdeaMapper.INSTANCE.ideaDToToIdea(ideaDTO);
        idea.setUser(UserMapper.INSTANCE.userResponseToUser(userService.findByPhoneNumber(ideaDTO.getPhone())));
        idea.setAddDate(LocalDate.now());
        idea = ideaRepo.saveAndFlush(idea);
        return IdeaMapper.INSTANCE.ideaToIdeaDTO(idea);
    }

    /*@Override
    public List<UserIdeasDTO> getUserIdeas(String phone) {
        return null;
    }*/


}
