package lab1.sportprenos.data;

import lab1.sportprenos.model.Match;
import lab1.sportprenos.model.Team;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DemoData {

    private static List<Team> teams = new ArrayList<>();
    private static List<Match> matches = new ArrayList<>();

    static {
        // Kreiranje timova
        teams.add(new Team(1L, "FK Sarajevo", "Bosna i Hercegovina", "Vinko Marinović", 1946));
        teams.add(new Team(2L, "FK Željezničar", "Bosna i Hercegovina", "Amar Osim", 1921));
        teams.add(new Team(3L, "FK Zrinjski", "Bosna i Hercegovina", "Blaž Slišković", 1905));
        teams.add(new Team(4L, "FK Velež", "Bosna i Hercegovina", "Saša Zorić", 1922));
        teams.add(new Team(5L, "FK Borac", "Bosna i Hercegovina", "Mladen Žižović", 1926));

        // Kreiranje utakmica
        matches.add(new Match(1L, teams.get(0), teams.get(1),
                LocalDateTime.now().plusDays(1), "Stadion Asim Ferhatović Hase", "Premijer Liga BIH", false));

        matches.add(new Match(2L, teams.get(2), teams.get(3),
                LocalDateTime.now().plusDays(2), "Stadion pod Bijelim Brijegom", "Premijer Liga BIH", false));

        matches.add(new Match(3L, teams.get(4), teams.get(0),
                LocalDateTime.now().plusDays(3), "Gradski stadion Banja Luka", "Premijer Liga BIH", false));

        matches.add(new Match(4L, teams.get(1), teams.get(2),
                LocalDateTime.now().plusHours(2), "Stadion Grbavica", "Kup BIH", true));

        matches.add(new Match(5L, teams.get(3), teams.get(4),
                LocalDateTime.now().plusDays(5), "Stadion Rođeni", "Premijer Liga BIH", false));
    }

    public List<Team> getAllTeams() {
        return teams;
    }

    public List<Match> getAllMatches() {
        return matches;
    }

    public Team getTeamById(Long id) {
        return teams.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Match getMatchById(Long id) {
        return matches.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void startStream(Long matchId) {
        Match match = getMatchById(matchId);
        if (match != null) {
            match.setLive(true);
        }
    }

    public void stopStream(Long matchId) {
        Match match = getMatchById(matchId);
        if (match != null) {
            match.setLive(false);
        }
    }
}
