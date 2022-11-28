package dat3.tour2022.dto;

import dat3.tour2022.entity.Rider;
import dat3.tour2022.entity.StageResult;
import dat3.tour2022.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RiderResponseTest {

  Rider rider;
  @BeforeEach
  void setUp() {
    Team team1 = new Team("Team 1");
    rider = new Rider("Rider-1",true,"Denmark");
    team1.addRider(rider);
    rider.addStageResult(StageResult.builder().stageName("S1").mountainPoint(1).sprintPoint(0).time(1000).build());
    rider.addStageResult(StageResult.builder().stageName("S2").mountainPoint(0).sprintPoint(3).time(990).build());
    rider.addStageResult(StageResult.builder().stageName("S3").mountainPoint(1).sprintPoint(1).time(1010).build());
  }

  @Test
  public void testConstructorIncludeAll(){
    RiderResponse res = new RiderResponse(rider,true,false);
    assertEquals("Team 1",res.getTeamName());
    assertEquals(3000,res.getTimeTotal());
    assertEquals(2,res.getMountainPointTotal());
    assertEquals(4,res.getSprintPointTotal());
  }
  @Test
  public void testConstructorIncludeNoScores(){
    RiderResponse res = new RiderResponse(rider,false,false);
    assertEquals("Team 1",res.getTeamName());
    assertNull(res.getTimeTotal());
    assertNull(res.getMountainPointTotal());
    assertNull(res.getSprintPointTotal());
  }
}