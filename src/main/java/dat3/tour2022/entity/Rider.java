package dat3.tour2022.entity;

import dat3.tour2022.dto.RiderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rider {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String name;
  String country;
  boolean below26;

  //@Formula("select sum(stage.time) from stageResult stage where stage.rider.id = id")
  //@Formula("select coalesce(sum(sr.time),0) from stage_result sr left join rider r on r.id = sr.rider_id and r.id = id")

 // int time;


  @OneToMany(mappedBy = "rider",cascade = CascadeType.ALL)
  private List<StageResult> stageResults = new ArrayList<>();

  @ManyToOne
  Team team;

  public Rider(String name, boolean below26,String country) {
    this.name = name;
    this.below26 = below26;
    this.country = country;
  }

  public Rider(RiderRequest r){
    this.name = r.getName();
    this.below26 = r.isBelow26();
    this.country = r.getCountry();
  }

  public void addStageResult(StageResult stageResult){
    stageResults.add(stageResult);
    stageResult.setRider(this);
  }

}
