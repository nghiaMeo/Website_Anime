package website.anime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import website.anime.model.Anime;

@Service
public interface AnimeService {
    List<Anime> getAllAnime();

    void updateAnime(Anime anime);

    void removeAnimeById(int id);

    Optional<Anime> getAnimneById(int id);

}
