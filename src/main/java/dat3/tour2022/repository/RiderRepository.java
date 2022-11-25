package dat3.tour2022.repository;

import dat3.tour2022.entity.Rider;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider,Integer> {
  List<Rider> findAllByTeam_Name(String name, Pageable pageable);

//  @Query("select new dat3.tour2022.dto.RiderResponse(r,sum(sr.time)) from Rider r left join r.stageResults sr on sr.rider.id = r.id ")
//  List<RiderResponse> findByTotalTime();
}
