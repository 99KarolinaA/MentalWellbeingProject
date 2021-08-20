package mk.ukim.finki.dnic.mentalwellbeing.service;

import mk.ukim.finki.dnic.mentalwellbeing.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Optional<Question> save(Long id,  String content, String answer);
    Optional<Question> save(Question q);
    List<Question> findAll();

}
