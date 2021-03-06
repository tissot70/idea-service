package kg.itschool.ideaservice.mappers;

import kg.itschool.ideaservice.models.dto.IdeaDTO;
import kg.itschool.ideaservice.models.entites.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE= Mappers.getMapper(IdeaMapper.class);

    Idea ideaDToToIdea(IdeaDTO ideaDTO);

    IdeaDTO ideaToIdeaDTO(Idea idea);
}
