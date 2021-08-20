package mk.ukim.finki.dnic.mentalwellbeing.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
public class Question {
    @Id
    private Long id;
    @Column(length=9999)
    private String content;
    private String answer;

    public Question(){

    }
    public Question(Long id, String content, String answer) {
        this.id = id;
        this.content = content;
        this.answer = answer;
    }

}
