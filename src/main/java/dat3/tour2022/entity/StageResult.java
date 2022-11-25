package dat3.tour2022.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StageResult {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String stageName;
  int time;
  int mountainPoint;
  int sprintPoint;

  @ManyToOne
  Rider rider;
}
