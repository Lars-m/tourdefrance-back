package dat3.tour2022.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiderRequest {
  String name;
  String country;
  boolean below26;
  Integer teamId;
}
