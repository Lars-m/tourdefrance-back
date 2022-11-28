package dat3.tour2022.repository;

import dat3.tour2022.entity.Rider;
import dat3.tour2022.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class RiderRepositoryTest {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @BeforeEach
  void setUp() {
    Team teamA = new Team("Team A");
    Team teamB = new Team("Team B");
    Team teamC = new Team("Team C");
    Rider riderA1 = new Rider("r1",false,"Denmark");
    Rider riderA2 = new Rider("r2",false,"Denmark");
    Rider riderA3 = new Rider("r3",false,"Denmark");
    teamA.addRider(riderA1);
    teamA.addRider(riderA2);
    teamA.addRider(riderA3);
    Rider riderB1 = new Rider("r4",false,"Denmark");
    teamB.addRider(riderB1);
    Rider riderC1 = new Rider("r4",false,"Denmark");
    teamC.addRider(riderC1);
    teamRepository.save(teamA);
    teamRepository.save(teamB);
    teamRepository.save(teamC);
  }

  @Test
  void findAllByTeam_NamePagination() {
    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
    List<Rider> ridersA = riderRepository.findAllByTeam_Name("Team A",firstPageWithTwoElements);
    assertEquals(2,ridersA.size());
  }
  @Test
  void findAllByTeam_All() {
    Pageable firstPageWithFourElements = PageRequest.of(0, 4);
    List<Rider> ridersA = riderRepository.findAllByTeam_Name("Team A",firstPageWithFourElements);
    assertEquals(3,ridersA.size());
  }
  @Test
  void findAllByTeam_Remaining() {
    Pageable firstPageWithFourElements = PageRequest.of(0, 4);
    List<Rider> ridersB = riderRepository.findAllByTeam_Name("Team B",firstPageWithFourElements);
    assertEquals(1,ridersB.size());
    List<Rider> ridersC = riderRepository.findAllByTeam_Name("Team C",firstPageWithFourElements);
    assertEquals(1,ridersC.size());
  }
}