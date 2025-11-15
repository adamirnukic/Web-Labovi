package lab1.sportprenos.controller;


import lab1.sportprenos.model.Match;
import lab1.sportprenos.model.Team;
import lab1.sportprenos.data.DemoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class AppController {

    private final DemoData demoData;

    public AppController(DemoData demoData) {
        this.demoData = demoData;
    }

    @GetMapping("/teams")
    public String listTeams(Model model) {
        List<Team> teams = demoData.getAllTeams();
        model.addAttribute("teams", teams);
        return "teams";
    }

    @GetMapping("/matches")
    public String listMatches(Model model) {
        List<Match> matches = demoData.getAllMatches();
        model.addAttribute("matches", matches);
        return "matches";
    }

    @GetMapping("/matches/start/{id}")
    public String startStream(@PathVariable Long id, Model model) {
        Match match = demoData.getMatchById(id);

        if (match != null) {
            demoData.startStream(id);
            model.addAttribute("match", match);
            model.addAttribute("action", "started");
            model.addAttribute("message", "Stream je uspješno pokrenut!");
        } else {
            model.addAttribute("action", "error");
            model.addAttribute("message", "Utakmica nije pronađena!");
        }

        return "action";
    }

    @GetMapping("/matches/stop/{id}")
    public String stopStream(@PathVariable Long id, Model model) {
        Match match = demoData.getMatchById(id);

        if (match != null) {
            demoData.stopStream(id);
            model.addAttribute("match", match);
            model.addAttribute("action", "stopped");
            model.addAttribute("message", "Stream je zaustavljen!");
        } else {
            model.addAttribute("action", "error");
            model.addAttribute("message", "Utakmica nije pronađena!");
        }

        return "action";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/matches";
    }
}
