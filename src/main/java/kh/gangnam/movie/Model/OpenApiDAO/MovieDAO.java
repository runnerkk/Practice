package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class MovieDAO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieNm;
    private String movieCd;

    @OneToMany(mappedBy = "movie")
    private List<ActorDAO> actorList = new ArrayList<>();

    public MovieDAO(String movieCd, String movieNm) {
    }

    public static MovieDAO create(String movieCd, String movieNm) {
        MovieDAO movie = new MovieDAO();
        movie.movieCd = movieCd;
        movie.movieNm = movieNm;
        return movie;
    }

    //배우 추가 메소드
    public void addActors(List<ActorDAO> actores) {
        this.actorList.addAll(actores);
    }
}
