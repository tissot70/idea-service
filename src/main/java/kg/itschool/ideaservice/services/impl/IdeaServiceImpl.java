package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.IdeaRepo;
import kg.itschool.ideaservice.mappers.IdeaMapper;
import kg.itschool.ideaservice.models.dto.IdeaDTO;
import kg.itschool.ideaservice.models.entites.Idea;
import kg.itschool.ideaservice.services.IdeaService;
import org.springframework.stereotype.Service;

@Service
public class IdeaServiceImpl implements IdeaService {

    private IdeaRepo ideaRepo;

    public IdeaServiceImpl(IdeaRepo ideaRepo) {
        this.ideaRepo = ideaRepo;
    }

    @Override
    public IdeaDTO save(IdeaDTO ideaDTO) {
        //найти пользователя по номеру телофона и присвоить
        Idea idea = IdeaMapper.INSTANCE.ideaDToToIdea(ideaDTO);
        idea = ideaRepo.save(idea);
        return IdeaMapper.INSTANCE.ideaToIdeaDTO(idea);
    }
}
