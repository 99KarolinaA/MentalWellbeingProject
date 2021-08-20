package mk.ukim.finki.dnic.mentalwellbeing.service.implementations;

import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import mk.ukim.finki.dnic.mentalwellbeing.model.enumeration.Category;
import mk.ukim.finki.dnic.mentalwellbeing.repository.TextRepository;
import mk.ukim.finki.dnic.mentalwellbeing.service.TextService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextServiceImpl implements TextService {
    private final TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public Optional<Text> save(Long id, String title, String content, String url, Category category) {
        return Optional.of(this.textRepository.save(new Text(id,title,content,url, category)));
    }

    @Override
    public List<Text> findAll() {
        return textRepository.findAll();
    }

    @Override
    public Optional<Text> findById(Long id) {
        return this.textRepository.findById(id);
    }

    @Override
    public List<Text> findAllByCategory(Category category) {
        return textRepository.findAllByCategory(category);
    }

    @Override
    public Optional<Text> save(Text text) {
        return Optional.of(this.textRepository.save(text));
    }

    @Override
    public List<Text> findAllByKey(String search) {
        return textRepository.findAllByContentIgnoreCaseContainsOrTitleIgnoreCaseContains(search, search);
    }
}
