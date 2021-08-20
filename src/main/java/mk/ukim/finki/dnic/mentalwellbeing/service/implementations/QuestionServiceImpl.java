package mk.ukim.finki.dnic.mentalwellbeing.service.implementations;

import mk.ukim.finki.dnic.mentalwellbeing.model.Question;
import mk.ukim.finki.dnic.mentalwellbeing.repository.QuestionRepository;
import mk.ukim.finki.dnic.mentalwellbeing.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Question> save(Long id, String content, String answer) {
        return Optional.of(this.questionRepository.save(new Question(id,content,answer)));
    }

    @Override
    public Optional<Question> save(Question q) {
        return Optional.of(this.questionRepository.save(q));
    }

    @Override
    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }
}
