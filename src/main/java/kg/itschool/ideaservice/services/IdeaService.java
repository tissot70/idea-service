package kg.itschool.ideaservice.services;

import kg.itschool.ideaservice.models.dto.IdeaDTO;
import kg.itschool.ideaservice.models.dto.UserIdeasDTO;

import java.util.List;

public interface IdeaService {

    IdeaDTO save(IdeaDTO ideaDTO);

    /*List<UserIdeasDTO> getUserIdeas(String phone);*/


}
