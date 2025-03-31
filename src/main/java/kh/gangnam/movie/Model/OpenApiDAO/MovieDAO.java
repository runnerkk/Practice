package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class MovieDAO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieNm;
    private String movieCd;

    @OneToMany(mappedBy = "movie")
    private List<ActorDAO> actorList;
}
