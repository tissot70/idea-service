package kg.itschool.ideaservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDTO {

    long id;
    String title;
    String text;
    boolean contactWithMe;
    String phone;
}
