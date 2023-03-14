package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Match {
    private LocalDateTime dateTime;
    private Team team1;
    private Team team2;

    public Match(LocalDateTime dateTime, Team team1, Team team2) {
        this.dateTime = dateTime;
        this.team1 = team1;
        this.team2 = team2;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(dateTime, match.dateTime) && Objects.equals(team1, match.team1) && Objects.equals(team2, match.team2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, team1, team2);
    }

    @Override
    public String toString() {
        return "\n" + dateTime + ";" + team1 + ";" + team2;
    }
}