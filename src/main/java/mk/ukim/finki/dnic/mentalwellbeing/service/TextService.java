package mk.ukim.finki.dnic.mentalwellbeing.service;

import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import mk.ukim.finki.dnic.mentalwellbeing.model.enumeration.Category;

import java.util.List;
import java.util.Optional;

public interface TextService {
    Optional<Text> save(Long id, String title, String content, String url, Category category);
    List<Text> findAll();
    Optional <Text> findById(Long id);
    List<Text> findAllByCategory(Category category);
    Optional<Text>save(Text text);
    List<Text> findAllByKey(String search);
}
