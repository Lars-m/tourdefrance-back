package dat3.tour2022.service;

import dat3.tour2022.dto.TeamResponse;
import dat3.tour2022.entity.Team;
import dat3.tour2022.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
  private TeamRepository teamRepository;

  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  public List<TeamResponse> getTeams(){
    List<Team> teams = teamRepository.findAll();
    return teams.stream().map(team -> new TeamResponse(team)).toList();
  }


}
