package dat3.tour2022.repository;

import dat3.tour2022.entity.StageResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StageResultRepository extends JpaRepository<StageResult, Integer> {

  @Query("SELECT DISTINCT sr.stageName FROM StageResult sr")
  List<String> getStageNames();

  @Query("SELECT sr from StageResult sr WHERE sr.rider.id = :id")
  List<StageResult> findStageResultsForRider(int id);

}


