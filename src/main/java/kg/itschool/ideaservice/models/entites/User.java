package kg.itschool.ideaservice.models.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    long id;
    String name;
    String phone;
    LocalDate addDate;
    String code;
    boolean activated;
}
