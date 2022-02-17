package kg.itschool.ideaservice.services;

import kg.itschool.ideaservice.models.dto.IdeaDTO;

import java.util.List;

public interface IdeaService {

    IdeaDTO save(IdeaDTO ideaDTO);

    //List<IdeaDTO> getUserIdeas(String phone);
}
