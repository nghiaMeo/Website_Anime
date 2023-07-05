package website.anime.dto;



import lombok.Data;
import website.anime.model.Genres;
import website.anime.model.Season;
import website.anime.model.Tag;
import java.util.Date;

import java.util.List;


@Data
public class AnimeDTO {
    private Long animeId;

    private String title;
    private List<Genres> genres;
    private Tag tags;
    private long view;
    private long like;
    private Date manufacturingDate;
    private String studio;
    private String description;
    private String  imgName;
    private List<Season> seasons;
}
