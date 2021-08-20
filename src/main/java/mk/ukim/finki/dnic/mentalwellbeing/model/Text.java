package mk.ukim.finki.dnic.mentalwellbeing.model;

import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.dnic.mentalwellbeing.model.enumeration.Category;

import javax.persistence.*;

@Data
@Entity
@Getter
public class Text {
    @Id
    private Long id;
    private String title;
    @Column(length=9999)
    private String content;
    private String photoUrl;

    @Enumerated(value =  EnumType.STRING)
    private Category category;

    public Text() {
    }

    public Text(Long id, String title, String content, String photoUrl, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photoUrl = photoUrl;
        this.category = category;
    }
}
