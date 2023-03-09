package service.impl;

import model.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonServiceImplTest {
    private static final String TEAMS = "teams";
    private static final String DATE = "date";
    private static final String TEAM_1 = "team_1";
    private static final String TEAM_2 = "team_2";
    @Test(expected = java.io.FileNotFoundException.class)
    public void fileNotFound() throws FileNotFoundException {
        new FileReader("src/main/resources/smartlab_soccer_teams2.json");
    }

    @Test
    public void parse() {
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

                assertNotNull(teamJsonObject.get(DATE));
                assertNotNull(teamJsonObject.get(TEAM_1));
                assertNotNull(teamJsonObject.get(TEAM_2));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

}