package kg.itschool.ideaservice.dao;

import kg.itschool.ideaservice.models.entites.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepo extends JpaRepository<Idea,Long> {
}
