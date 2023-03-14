package service.impl;

import model.Match;
import model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonServiceImplTest {
    private Util util = new Util();
    @Test
    void testGenerateMatches() {
        List<Team> teams = List.of(
                new Team("Team 1"),
                new Team("Team 2"),
                new Team("Team 3"),
                new Team("Team 4"),
                new Team("Team 5"),
                new Team("Team 6")
        );

        List<Match> matches = util.generateMatches(teams);

        Assertions.assertEquals(6, teams.size());
        for (Team team : teams) {
            int count = 0;
            Map<Team, Team> map = new HashMap<>();
            for (Match match : matches) {
                if (match.getTeam1().equals(team) || match.getTeam2().equals(team)) {
                    map.put(match.getTeam1(), match.getTeam2());
                    count++;
                }
            }
            System.out.println(map.size());
            Assertions.assertEquals(4, count);
        }

        for (Match match : matches) {
            Assertions.assertNotEquals(match.getTeam1(), match.getTeam2());
        }
    }
}