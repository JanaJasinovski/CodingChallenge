package view;

import model.Match;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MatchPlanView {
    private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public void print(List<Match> matches) {
        for (Match match : matches) {
            System.out.println(
                    match.getDateTime().format(DATE_TIME_FORMATTER) + ";" +
                            match.getTeam1().getName() + ";" +
                            match.getTeam2().getName()
            );
        }
    }
}
