package kh.gangnam.movie.Model.OpenApiDTO;

import kh.gangnam.movie.Model.OpenApiDAO.MovieDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Movie {

    private String movieCd;
    private String movieNm;
    private List<Actor> actorList;

    //MovieDAO -> DTO 변환
    public Movie(MovieDAO movieDAO) {
        this.movieCd = movieDAO.getMovieCd();
        this.movieNm = movieDAO.getMovieNm();

        //MovieDAO에서 ActorDAO리스트를 가져와서 Actor리스트로 변환
        this.actorList = movieDAO.getActorList().stream()
                .map(Actor::new)
                .collect(Collectors.toList());
    }
}
