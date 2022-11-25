package dat3.tour2022.api;

import dat3.tour2022.dto.RiderRequest;
import dat3.tour2022.dto.RiderResponse;
import dat3.tour2022.service.RiderService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/riders")
@CrossOrigin
public class RiderController {

  RiderService riderService;

  public RiderController(RiderService riderService) {
    this.riderService = riderService;
  }

  @PostMapping
  public RiderResponse addRider(@RequestBody RiderRequest body){
    return riderService.addRider(body);
  }

  @PutMapping("/{id}")
  public RiderResponse editRider(@RequestBody RiderRequest body, @PathVariable int id){
    return riderService.editRider(body,id);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteRider(@PathVariable int id){
    riderService.deleteRider(id);
    return  new ResponseEntity<>("{\"status\":\"OK\"}", HttpStatus.OK);
  }

  @GetMapping("/scores")
  public List<RiderResponse> getRidersWithScores(){
    return riderService.getRidersFullDetail();
  }

  @GetMapping
  public List<RiderResponse> getRiders(Pageable pageable, @PathVariable(required = false) String team){
    return riderService.getRiders(pageable,team);
  }
  @GetMapping("/{id}")
  public RiderResponse getRider(@PathVariable int id){
    return riderService.getRider(id);
  }

  @GetMapping(value = "/count", produces = "application/json")
  public ResponseEntity<String> getCount(){
    return riderService.riderCount();
  }


}
