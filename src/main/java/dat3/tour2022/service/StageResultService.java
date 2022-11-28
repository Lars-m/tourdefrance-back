package dat3.tour2022.service;

import dat3.tour2022.dto.StageResultDTO;
import dat3.tour2022.dto.StageResultUpdateRequest;
import dat3.tour2022.entity.StageResult;
import dat3.tour2022.repository.RiderRepository;
import dat3.tour2022.repository.StageResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageResultService {
  private StageResultRepository stageResultRepository;
  private RiderRepository riderRepository;

   public StageResultService(StageResultRepository stageResultRepository, RiderRepository riderRepository) {
    this.stageResultRepository = stageResultRepository;
    this.riderRepository = riderRepository;
  }

  public ResponseEntity<String> updateStageResults(StageResultUpdateRequest body, int riderId){
    List<StageResult> stageResults= stageResultRepository.findStageResultsForRider(riderId);
    for(StageResultDTO srDto: body.getStageResults()){
      StageResult stageResult = stageResults.stream().filter(sr-> sr.getId() == srDto.getId()).findFirst().get();
      stageResult.setTime(srDto.getTime());
      stageResult.setMountainPoint(srDto.getMountainPoint());
      stageResult.setSprintPoint(srDto.getSprintPoint());
    }
    stageResultRepository.saveAll(stageResults);
    return new ResponseEntity<String>("{\"status\":\"StageResults for rider-id: "+riderId+" was updated\"}", HttpStatus.OK);
  }
}
