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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class JsonServiceImpl {
    private static final String TEAMS = "teams";
    private static final String DATE = "date";
    private static final String TEAM_1 = "team_1";
    private static final String TEAM_2 = "team_2";

    private Root readFromJson() {
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

    public Root playCommands() {
        Root root = new Root();

        Set<String> team_1Set = new HashSet<>(readFromJson().getTeam_1());
        Set<String> team_2Set = new HashSet<>(readFromJson().getTeam_2());

        List<String> team_1List = new ArrayList<>(team_1Set);
        List<String> team_2List = new ArrayList<>(team_2Set);

        List<String> all = new ArrayList<>();
        all.addAll(team_1List);
        all.addAll(team_2List);

        Map<List<String>, List<String>> source = Map.of(
                team_1List, all
        );

        for (Map.Entry<List<String>, List<String>> entry : source.entrySet()) {
            for (int i = 0; i < entry.getKey().size(); i++) {
                for (int j = 0; j < entry.getValue().size(); j++) {
                    if(!entry.getKey().get(i).equals(entry.getValue().get(j)))
                    System.out.println(entry.getKey().get(i) + ": " + entry.getValue().get(j));

                }
            }
        }

        return root;
    }


//    @Override
//    public Root playCommands() {
//        Root root = new Root();
//        JSONParser parser = new JSONParser();
//        try (FileReader reader = new FileReader("src/main/resources/smartlab_soccer_teams.json")) {
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            JSONArray jsonArray = (JSONArray) jsonObject.get(TEAMS);
//
//            Set<String> teamSet = new HashSet<>();
//            List<Team> teamList = new ArrayList<>();
//            List<String> dateList = new ArrayList<>();
//            List<String> team_2List = new ArrayList<>();
//            for (Object o : jsonArray) {
//                JSONObject teamJsonObject = (JSONObject) o;
//                String date = (String) teamJsonObject.get(DATE);
//                String team_1 = (String) teamJsonObject.get(TEAM_1);
//                String team_2 = (String) teamJsonObject.get(TEAM_2);
//
//                dateList.add(date);
//                teamSet.add(team_1);
//                teamSet.add(team_2);
//                team_2List.add(team_2);
//            }
//
//            int size = teamSet.size();
//            System.out.println(teamSet);
//            System.out.println("\n\n");
//            int numberOfTournaments = getFactorial(size) / ((getFactorial(2) * getFactorial(size - 2)));
//
//            List<String> fromSetToList = new ArrayList<>(teamSet);
//
//            for(int k = 0; k < numberOfTournaments; k++) {
//                for (int i = 0; i < fromSetToList.size(); i++) {
//                    for (int j = 0; j < )
//                }
//            }
//            System.out.println(teamList);
//            root.setTeams(teamList);
//
//        } catch (IOException | ParseException e) {
//            throw new RuntimeException(e);
//        }
//        return root;
//    }
//
//    public Root parse() {
//        Root root = new Root();
//        root.setTeams(readFromJson());
//        return root;
//    }
//
//    @Override
//    public Root changePlaces() {
//        Root root = new Root();
//        JSONParser parser = new JSONParser();
//        try (FileReader reader = new FileReader("src/main/resources/smartlab_soccer_teams.json")) {
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            JSONArray jsonArray = (JSONArray) jsonObject.get(TEAMS);
//
//            List<Team> teamList = new ArrayList<>();
//            for (Object o : jsonArray) {
//                JSONObject teamJsonObject = (JSONObject) o;
//                String date = (String) teamJsonObject.get(DATE);
//                String team_1 = (String) teamJsonObject.get(TEAM_1);
//                String team_2 = (String) teamJsonObject.get(TEAM_2);
//                Team team = new Team(date, team_2, team_1);
//
//                teamList.add(team);
//            }
//
//            root.setTeams(teamList);
//
//        } catch (Exception e) {
//            System.out.println("Parsing error " + e.toString());
//        }
//
//        return root;
//    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
