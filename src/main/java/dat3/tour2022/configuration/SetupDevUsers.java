package dat3.tour2022.configuration;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import dat3.tour2022.entity.Rider;
import dat3.tour2022.entity.StageResult;
import dat3.tour2022.entity.Team;
import dat3.tour2022.repository.TeamRepository;
import dat3.tour2022.settings.SharedConstants;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupDevUsers implements ApplicationRunner {


    String S1 = SharedConstants.S1;
    String S2 = SharedConstants.S2;
    String S3 = SharedConstants.S3;


    UserWithRolesRepository userWithRolesRepository;
    TeamRepository teamRepository;
    String passwordUsedByAll;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, TeamRepository teamRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.teamRepository = teamRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        int TIME_ALL = 60*250;
        Team teamA = new Team("Team A");
        Team teamB = new Team("Team B");
        Team teamC = new Team("Team C");
        Rider riderA1 = new Rider("Rider-1 Team A Young",true,"Denmark");
        teamA.addRider(riderA1);
        Rider riderA2 =  new Rider("Rider-2 Team A",false,"France");
        teamA.addRider(riderA2);
        Rider riderA3 =  new Rider("Rider-3 Team A",false, "France");
        teamA.addRider(riderA3);

        riderA1.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-15).build());
        riderA1.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL).build());
        riderA1.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL-10).build());

        riderA2.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-15).build());
        riderA2.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL).build());
        riderA2.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL).build());

        riderA3.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL).build());
        riderA3.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL).build());
        riderA3.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL-33).build());

        Rider riderB1 =  new Rider("Rider-1 Team B",false, "Sweden");
        teamB.addRider(riderB1);
        Rider riderB2 =  new Rider("Rider-2 Team B Young",true,"Germany");
        teamB.addRider(riderB2);
        Rider riderB3 =  new Rider("Rider-3 Team B",false,"France");
        teamB.addRider(riderB3);
        riderB1.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL).build());
        riderB1.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL).build());
        riderB1.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+10).build());

        riderB2.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-25).build());
        riderB2.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL).build());
        riderB2.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+20).build());

        riderB3.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-5).build());
        riderB3.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(2).time(TIME_ALL+10).build());
        riderB3.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+-20).build());

        Rider riderC1 =  new Rider("Rider-1 Team C",false,"Denmark");
        teamC.addRider(riderC1);
        Rider riderC2 =  new Rider("Rider-2 Team C Young",false,"USA");
        teamC.addRider(riderC2);
        Rider riderC3 =  new Rider("Rider-3 Team C Young",true,"USA");
        teamC.addRider(riderC3);
        riderC1.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL+1).build());
        riderC1.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL+5).build());
        riderC1.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+4).build());

        riderC2.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-10).build());
        riderC2.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(3).time(TIME_ALL-12).build());
        riderC2.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+11).build());

        riderC3.addStageResult(StageResult.builder().stageName(new String(S1)).mountainPoint(1).sprintPoint(0).time(TIME_ALL-4).build());
        riderC3.addStageResult(StageResult.builder().stageName(new String(S2)).mountainPoint(0).sprintPoint(2).time(TIME_ALL+1).build());
        riderC3.addStageResult(StageResult.builder().stageName(new String(S3)).mountainPoint(0).sprintPoint(1).time(TIME_ALL+-14).build());

        teamRepository.save(teamA);
        teamRepository.save(teamB);
        teamRepository.save(teamC);




        setupUserWithRoleUsers();
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {
        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }
}
