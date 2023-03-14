package controller;

import model.Match;
import model.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.impl.Util;
import view.MatchPlanView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static util.Constants.FILENAME;

public class MatchController {
    private Util util = new Util();
    private MatchPlanView planView = new MatchPlanView();

    public void printMatches() throws Exception {
        List<Team> teams = util.readTeamsFromFile(FILENAME);
        List<Team> listWithoutDuplicates =
                teams.stream().distinct().toList();
        List<Match> matches = util.generateMatches(listWithoutDuplicates);
        planView.print(matches);
    }
}