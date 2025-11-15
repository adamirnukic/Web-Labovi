package lab1.sportprenos.service;

import lab1.sportprenos.model.Match;
import lab1.sportprenos.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public void startStream(Long id) {
        Optional<Match> matchOpt = matchRepository.findById(id);
        if (matchOpt.isPresent()) {
            Match match = matchOpt.get();
            match.setLive(true);
            matchRepository.save(match);
        }
    }

    public void stopStream(Long id) {
        Optional<Match> matchOpt = matchRepository.findById(id);
        if (matchOpt.isPresent()) {
            Match match = matchOpt.get();
            match.setLive(false);
            matchRepository.save(match);
        }
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
