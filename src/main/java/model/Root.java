package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Root {

   private Collection<Team> teams;

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Example" + teams;
    }

    public List<String> getTeam_1() {
        List<String> team_1List = new ArrayList<>();
        for (Team team_1: teams) {
            team_1List.add(team_1.getTeam_1());
        }
        return team_1List;
    }

    public List<String> getTeam_2() {
        List<String> team_2List = new ArrayList<>();
        for (Team team_1: teams) {
            team_2List.add(team_1.getTeam_2());
        }
        return team_2List;
    }
}
