package service.impl;

import model.Root;
import model.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.JsonService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonServiceImpl implements JsonService {
    private static final String TEAMS = "teams";
    private static final String DATE = "date";
    private static final String TEAM_1 = "team_1";
    private static final String TEAM_2 = "team_2";

    private List<Team> readFromJson() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/smartlab_soccer_teams.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get(TEAMS);

            List<Team> teamList = new ArrayList<>();
            for (Object o : jsonArray) {
                JSONObject teamJsonObject = (JSONObject) o;
                String date = (String) teamJsonObject.get(DATE);
                String team_1 = (String) teamJsonObject.get(TEAM_1);
                String team_2 = (String) teamJsonObject.get(TEAM_2);
                Team team = new Team(date, team_1, team_2);

                teamList.add(team);
            }
            return teamList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Root parse() {
        Root root = new Root();
        root.setTeams(readFromJson());
        return root;
    }

    @Override
    public Root changePlaces() {
        Root root = new Root();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/smartlab_soccer_teams.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get(TEAMS);

            List<Team> teamList = new ArrayList<>();
            for (Object o : jsonArray) {
                JSONObject teamJsonObject = (JSONObject) o;
                String date = (String) teamJsonObject.get(DATE);
                String team_1 = (String) teamJsonObject.get(TEAM_1);
                String team_2 = (String) teamJsonObject.get(TEAM_2);
                Team team = new Team(date, team_2, team_1);

                teamList.add(team);
            }

            root.setTeams(teamList);

        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return root;
    }
}
