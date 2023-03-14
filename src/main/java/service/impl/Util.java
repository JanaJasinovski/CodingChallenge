package service.impl;

import model.Match;
import model.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Constants.TEAM_1;
import static util.Constants.TEAM_2;

public class Util {
    private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public List<Team> readTeamsFromFile(String filename) throws Exception {
        List<Team> teams = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filename));
        for (Object obj : jsonArray) {
            JSONObject jsonObj = (JSONObject) obj;
            String teamName1 = (String) jsonObj.get(TEAM_1);
            String teamName2 = (String) jsonObj.get(TEAM_2);
            teams.add(new Team(teamName1));
            teams.add(new Team(teamName2));
        }
        return teams;
    }

    public List<Match> generateMatches(List<Team> teams) {
        List<Match> matches = new ArrayList<>();
        LocalDate startDate = LocalDate.parse("17.10.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate endDate = LocalDate.parse("07.11.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                List<Team> teamsCopy = new ArrayList<>(teams);
                Collections.shuffle(teamsCopy);
                for (int i = 0; i < teamsCopy.size() - 1; i += 2) {
                    Team team1 = teamsCopy.get(i);
                    Team team2 = teamsCopy.get(i + 1);
                    matches.add(new Match(currentDate.atTime(17, 0), team1, team2));
                }
            }
            currentDate = currentDate.plusDays(1);
        }
        return matches;
    }
}
