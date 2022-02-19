package kg.itschool.ideaservice.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserIdeasDTO {
    String title;
    String body;
    String contactWithMe;
}
