package mk.ukim.finki.dnic.mentalwellbeing.repository;

import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import mk.ukim.finki.dnic.mentalwellbeing.model.enumeration.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends JpaRepository <Text, Long>{

    List<Text> findAllByCategory(Category category);
    List<Text> findAllByContentIgnoreCaseContainsOrTitleIgnoreCaseContains(String content, String title);
}
