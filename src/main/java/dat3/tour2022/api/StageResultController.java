package dat3.tour2022.api;

import dat3.tour2022.dto.StageResultUpdateRequest;
import dat3.tour2022.service.StageResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/stageresults")
@CrossOrigin
public class StageResultController {

  StageResultService stageResultService;

  public StageResultController(StageResultService stageResultService) {
    this.stageResultService = stageResultService;
  }


  @PutMapping("/{riderId}")
  public ResponseEntity<String> updateStageResults(@RequestBody StageResultUpdateRequest body, @PathVariable int riderId){
    return stageResultService.updateStageResults(body,riderId);
  }
}
