package dat3.tour2022.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.tour2022.entity.StageResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StageResultDTO {
  int id;
  String stageName;
  int time;
  int mountainPoint;
  int sprintPoint;
  int riderId;

  public StageResultDTO(StageResult sr,boolean includeRideriD) {
    this.id = sr.getId();
    this.time = sr.getTime();
    this.mountainPoint = sr.getMountainPoint();
    this.sprintPoint = sr.getSprintPoint();
    this.stageName = sr.getStageName();
    if(includeRideriD) {
      this.riderId = sr.getRider().getId();
    }
  }
}
