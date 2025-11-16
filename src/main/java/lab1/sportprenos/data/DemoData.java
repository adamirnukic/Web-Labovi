package lab1.sportprenos.data;

import lab1.sportprenos.model.Match;
import lab1.sportprenos.model.Team;
import lab1.sportprenos.model.Player;
import lab1.sportprenos.repository.MatchRepository;
import lab1.sportprenos.repository.TeamRepository;
import lab1.sportprenos.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DemoData implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (teamRepository.count() > 0 || matchRepository.count() > 0 || playerRepository.count() > 0) {
            System.out.println("Baza podataka već sadrži podatke. Preskačem inicijalizaciju.");
            return;
        }

        System.out.println("Baza podataka je prazna. Inicijalizujemo demo podatke...");

        // Kreiranje timova
        Team sarajevo = teamRepository.save(new Team(null, "FK Sarajevo", "Bosna i Hercegovina", "Vinko Marinović", 1946));
        Team zeljeznicar = teamRepository.save(new Team(null, "FK Željezničar", "Bosna i Hercegovina", "Amar Osim", 1921));
        Team velez = teamRepository.save(new Team(null, "FK Velež", "Bosna i Hercegovina", "Slaven Musa", 1922));
        Team zrinjski = teamRepository.save(new Team(null, "HSK Zrinjski", "Bosna i Hercegovina", "Blaž Slišković", 1905));
        Team borac = teamRepository.save(new Team(null, "FK Borac", "Bosna i Hercegovina", "Mladen Žižović", 1926));

        // Kreiranje utakmica
        Match match1 = matchRepository.save(new Match(null, sarajevo, zeljeznicar,
                LocalDateTime.of(2024, 12, 20, 18, 0), "Olimpijski stadion Asim Ferhatović Hase",
                "Premijer Liga BiH", true));

        Match match2 = matchRepository.save(new Match(null, velez, zrinjski,
                LocalDateTime.of(2024, 12, 21, 20, 0), "Stadion Rođeni",
                "Premijer Liga BiH", false));

        Match match3 = matchRepository.save(new Match(null, borac, sarajevo,
                LocalDateTime.of(2024, 12, 22, 19, 0), "Gradski stadion",
                "Premijer Liga BiH", false));

        Match match4 = matchRepository.save(new Match(null, zeljeznicar, velez,
                LocalDateTime.of(2024, 12, 23, 17, 30), "Stadion Grbavica",
                "Premijer Liga BiH", true));

        Match match5 = matchRepository.save(new Match(null, zrinjski, borac,
                LocalDateTime.of(2024, 12, 24, 16, 0), "Stadion pod Bijelim Brijegom",
                "Premijer Liga BiH", false));

        // Igrači FK Sarajevo
        playerRepository.save(new Player(null, "Edin Džeko", "Napadač", 11,
                LocalDate.of(1986, 3, 17), "Bosna i Hercegovina", sarajevo));
        playerRepository.save(new Player(null, "Miralem Pjanić", "Centralni vezni", 5,
                LocalDate.of(1990, 4, 2), "Bosna i Hercegovina", sarajevo));
        playerRepository.save(new Player(null, "Asmir Begović", "Golman", 1,
                LocalDate.of(1987, 6, 20), "Bosna i Hercegovina", sarajevo));

        // Igrači FK Željezničar
        playerRepository.save(new Player(null, "Zvjezdan Misimović", "Ofanzivni vezni", 10,
                LocalDate.of(1982, 6, 5), "Bosna i Hercegovina", zeljeznicar));
        playerRepository.save(new Player(null, "Sead Kolašinac", "Lijevi bek", 3,
                LocalDate.of(1993, 6, 20), "Bosna i Hercegovina", zeljeznicar));

        // Igrači FK Velež
        playerRepository.save(new Player(null, "Vedad Ibišević", "Napadač", 9,
                LocalDate.of(1984, 8, 6), "Bosna i Hercegovina", velez));
        playerRepository.save(new Player(null, "Haris Medunjanin", "Defanzivni vezni", 6,
                LocalDate.of(1985, 3, 8), "Bosna i Hercegovina", velez));

        // Igrači HSK Zrinjski
        playerRepository.save(new Player(null, "Nemanja Bilbija", "Napadač", 99,
                LocalDate.of(1995, 9, 23), "Bosna i Hercegovina", zrinjski));
        playerRepository.save(new Player(null, "Josip Ćorluka", "Štoper", 4,
                LocalDate.of(1986, 4, 12), "Hrvatska", zrinjski));

        // Igrači FK Borac
        playerRepository.save(new Player(null, "Stojan Vranješ", "Štoper", 5,
                LocalDate.of(1986, 1, 8), "Bosna i Hercegovina", borac));
        playerRepository.save(new Player(null, "Darko Maletić", "Centralni vezni", 8,
                LocalDate.of(1993, 5, 15), "Bosna i Hercegovina", borac));

        System.out.println("Baza podataka je uspješno inicijalizovana sa igračima!");
    }
}
