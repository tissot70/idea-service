package kg.itschool.ideaservice.dao;

import kg.itschool.ideaservice.models.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
