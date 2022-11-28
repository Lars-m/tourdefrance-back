package dat3.tour2022.settings;

import java.util.Arrays;
import java.util.List;

public class SharedConstants {
 /*
 Hardcoded to only three stages, a better (a bit more complex) solution would be
 two tables, STAGE (1)-->(*) STAGERESULT
  */
 public static final String S1 = "Stage 1";
 public static final String S2 = "Stage 2";
 public static final String S3 = "Stage 3";

 public static final List<String> stageNames= Arrays.asList(S1,S2,S3);
}
