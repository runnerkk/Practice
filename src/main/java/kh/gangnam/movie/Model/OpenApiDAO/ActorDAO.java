package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ActorDAO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String peopleCd;
    private String peopleNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieDAO movie;
}
