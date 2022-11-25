package dat3.tour2022.api;

import dat3.tour2022.dto.TeamResponse;
import dat3.tour2022.service.TeamService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/teams")
@CrossOrigin
public class TeamController {
  TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping
  public List<TeamResponse> getTeams(){
    return teamService.getTeams();
  }
}
