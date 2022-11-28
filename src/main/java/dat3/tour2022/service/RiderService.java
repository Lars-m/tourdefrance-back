package dat3.tour2022.service;

import dat3.tour2022.dto.RiderRequest;
import dat3.tour2022.dto.RiderResponse;
import dat3.tour2022.entity.Rider;
import dat3.tour2022.entity.StageResult;
import dat3.tour2022.entity.Team;
import dat3.tour2022.repository.RiderRepository;
import dat3.tour2022.repository.TeamRepository;
import dat3.tour2022.settings.SharedConstants;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RiderService {

  RiderRepository riderRepository;
  TeamRepository teamRepository;

  public RiderService(RiderRepository riderRepository, TeamRepository teamRepository) {
    this.riderRepository = riderRepository;
    this.teamRepository = teamRepository;
  }

  public RiderResponse addRider(RiderRequest body){
    Rider rider = new Rider(body);
    if(body.getTeamId() !=null){
      Team team = teamRepository.findById(body.getTeamId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Team does not exist"));
      rider.setTeam(team);
    }
    //Add all stages to new riders with empty results
    for(String stageResultName: SharedConstants.stageNames){
      rider.addStageResult(StageResult.builder().stageName(new String(stageResultName)).build());
    }
    return new RiderResponse(riderRepository.save(rider),false,false);
  }

  public List<RiderResponse> getRidersFullDetail(){
    List<Rider> riders = riderRepository.findAll();
    return riders.stream().map(rider -> new RiderResponse(rider,true,false)).toList();
  }

  public List<RiderResponse> getRiders(Pageable pageable, String team){
    List<Rider> riders = null;
    if(team !=null){
      riders = riderRepository.findAllByTeam_Name(team,pageable);
    } else {
      riders = riderRepository.findAll(pageable).toList();
    }
    return riders.stream().map(r -> new RiderResponse(r,false,false)).toList();
  }

  public RiderResponse getRider(int id,boolean addStages){
    Rider rider = riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No rider found with ID: "+id));
    return new RiderResponse(rider,false,addStages);
  }

  public ResponseEntity<String> riderCount(){
    return new ResponseEntity<>("{\"count\":"+ riderRepository.count()+"}", HttpStatus.OK);
  }

  public RiderResponse editRider(RiderRequest body, int riderId){
    Rider rider = riderRepository.findById(riderId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No rider found with ID: "+riderId));
    if(rider.getTeam().getId() != body.getTeamId()) {
      Team oldTeam = teamRepository.findById(rider.getTeam().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Old team not found"));
      oldTeam.removeRider(rider);
      Team t = teamRepository.findById(body.getTeamId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No team with provided ID found"));
      t.addRider(rider);
    }
    rider.setName(body.getName());
    rider.setCountry(body.getCountry());
    rider.setBelow26(body.isBelow26());
    return new RiderResponse(riderRepository.save(rider),false,false);
  }

  public void deleteRider(int riderId){
    Rider rider = riderRepository.findById(riderId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No rider found with ID: "+riderId));
    riderRepository.delete(rider);
  }



}
