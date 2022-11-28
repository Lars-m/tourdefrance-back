package dat3.tour2022.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.tour2022.entity.Rider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiderResponse {
  int id;
  String name;
  boolean below26;
  String country;
  String teamName;
  Integer teamId;
  Integer timeTotal;
  Integer mountainPointTotal;
  Integer sprintPointTotal;
  List<StageResultDTO> stageResults;

  public RiderResponse(Rider rider, boolean includePoints, boolean includeStageResults) {
    id = rider.getId();
    name = rider.getName();
    below26 = rider.isBelow26();
    country = rider.getCountry();
    teamName = rider.getTeam().getName();
    teamId = rider.getTeam().getId();
    if (includePoints == true) {
      timeTotal = rider.getStageResults().stream().mapToInt(sr -> sr.getTime()).sum();
      mountainPointTotal = rider.getStageResults().stream().mapToInt(sr -> sr.getMountainPoint()).sum();
      sprintPointTotal = rider.getStageResults().stream().mapToInt(sr -> sr.getSprintPoint()).sum();
    }
    if(includeStageResults){
      stageResults = rider.getStageResults().stream().map(r->new StageResultDTO(r,false)).toList();
    }
  }
}
