package dat3.tour2022.service;

import dat3.tour2022.dto.RiderRequest;
import dat3.tour2022.dto.RiderResponse;
import dat3.tour2022.entity.Rider;
import dat3.tour2022.entity.Team;
import dat3.tour2022.repository.RiderRepository;
import dat3.tour2022.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RiderServiceTest {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  RiderRepository riderRepository;

  RiderService riderService;

  int riderA1Id;
  int teamA_Id;
  @BeforeEach
  void setupBeforeEach() {
    Team teamA = new Team("Team A");
    Rider riderA1 = new Rider("r1",false,"Denmark");
    Rider riderA2 = new Rider("r2",false,"Denmark");
    teamA.addRider(riderA1);
    teamA.addRider(riderA2);
    teamRepository.save(teamA);
    riderA1Id = riderA1.getId();
    teamA_Id = teamA.getId();
    riderService = new RiderService(riderRepository,teamRepository);
  }

  @Test
  void addRider() {
    RiderRequest request = new RiderRequest("rider","Denmark",false,teamA_Id );
    RiderResponse response = riderService.addRider(request);
    assertNotNull(response.getId());

    String bodyAsString = riderService.riderCount().getBody().toString();
    assertTrue(bodyAsString.indexOf("3")>0);
  }

  @Test
  void getRider() {
    RiderResponse res = riderService.getRider(riderA1Id,false);
    assertEquals("r1",res.getName());
  }

  @Test
  void riderCount() {
    ResponseEntity<String> res = riderService.riderCount();
    String name= res.getBody().toString();
    assertTrue(name.indexOf("2")>0);
  }

  @Test
  void editRider() {
  }

  @Test
  void deleteRider() {
  }
}