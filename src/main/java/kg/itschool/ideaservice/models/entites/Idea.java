package kg.itschool.ideaservice.models.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String text;
    LocalDate addDate;
    boolean contactWithMe;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
