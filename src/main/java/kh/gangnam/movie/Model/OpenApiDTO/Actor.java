package kh.gangnam.movie.Model.OpenApiDTO;

import kh.gangnam.movie.Model.OpenApiDAO.ActorDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Actor {

    private String peopleCd;
    private String peopleNm;

    //ActorDAO -> DTO 변환
    public Actor(ActorDAO actorDAO) {
        this.peopleCd = actorDAO.getPeopleCd();
        this.peopleNm = actorDAO.getPeopleNm();
    }
}
