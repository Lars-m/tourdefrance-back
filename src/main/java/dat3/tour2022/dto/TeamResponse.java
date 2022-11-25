package dat3.tour2022.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.tour2022.entity.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse {
  int id;
  String teamName;

  public TeamResponse(Team team) {
    this.id = team.getId();
    this.teamName = team.getName();
  }
}
