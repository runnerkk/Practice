package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class ActorDAO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String peopleCd;
    private String peopleNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieDAO movie;

    public ActorDAO(String peopleCd, String peopleNm, MovieDAO movieDAO) {
    }

    public static ActorDAO create(String peopleCd, String peopleNm, MovieDAO movie) {
        ActorDAO actor = new ActorDAO();
        actor.peopleCd = peopleCd;
        actor.peopleNm = peopleNm;
        actor.movie = movie;
        return actor;
    }
}
