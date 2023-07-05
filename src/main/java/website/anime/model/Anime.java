package website.anime.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import org.springframework.beans.BeanUtils;

import java.util.Date;

@Entity
@Data
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animeId;

    private String title;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genres> genres;

    @Enumerated(EnumType.STRING)
    private Tag tags;

    private long view;
    private long like;
    private Date manufacturingDate;
    private String studio;
    private String description;
    private String  imgName;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasons;

    public Anime() {

    }

    public Anime(Anime anime) {
        BeanUtils.copyProperties(anime, this);
    }

}
