package dat3.tour2022.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(length = 40)
  String name;

  public Team(String name) {
    this.name = name;
  }

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
  Set<Rider> riders = new HashSet<>();

  public void addRider(Rider rider){
    riders.add(rider);
    rider.setTeam(this);
  }
  public void removeRider(Rider rider){
    riders.remove(rider);
    rider.setTeam(null);
  }

}
