package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String TEAMS = "teams";
    public static final String DATE = "date";
    public static final String TEAM_1 = "team_1";
    public static final String TEAM_2 = "team_2";

    public static final String FILENAME = "src/main/resources/smartlab_soccer_teams.json";
    public static final int BUFFER_SIZE = 1024;
    public static final int NUM_TEAMS = 4;
    public static final LocalDate START_DATE = LocalDate.of(2020, 10, 17);
    public static final LocalDate SECOND_ROUND_START_DATE = START_DATE.plusWeeks(3).plusDays(1);
    public static final LocalTime GAME_TIME = LocalTime.of(17, 0);
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    public static final int GAMES_PER_WEEK = 3;
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static final int NUM_ROUNDS = 2;
    public static final int WEEKS_BETWEEN_ROUNDS = 3;
}
