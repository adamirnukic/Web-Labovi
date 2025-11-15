package lab1.sportprenos.controller;

import lab1.sportprenos.model.Player;
import lab1.sportprenos.service.PlayerService;
import lab1.sportprenos.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("/new")
    public String showNewPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.getAllTeams());
        return "player-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditPlayerForm(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nevažeći ID igrača: " + id));
        model.addAttribute("player", player);
        model.addAttribute("teams", teamService.getAllTeams());
        return "player-form";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "redirect:/players";
    }
}
