package mk.ukim.finki.dnic.mentalwellbeing.repository;

import mk.ukim.finki.dnic.mentalwellbeing.model.Question;
import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long> {
}
