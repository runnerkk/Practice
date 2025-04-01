package kh.gangnam.movie.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kh.gangnam.movie.Model.OpenApiDAO.ActorDAO;
import kh.gangnam.movie.Model.OpenApiDAO.MovieDAO;
import kh.gangnam.movie.Model.OpenApiDTO.Actor;
import kh.gangnam.movie.Model.OpenApiDTO.Movie;
import kh.gangnam.movie.Repository.ActorDAORepository;
import kh.gangnam.movie.Repository.MovieDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieActorService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final MovieDAORepository movieDAORepository;
    private final ActorDAORepository actorDAORepository;

    @Value("${openapi.api-key}")
    private String apikey;
    @Value("${openapi.daily}")
    private String url;

    //영화 배우정보 저장
    public Movie saveMovieActors(String movieCd) throws JsonProcessingException {
        String URL = url + "?key=" + apikey + "&movieCd=" + movieCd;
        String response = restTemplate.getForObject(URL, String.class);

        JsonNode root = objectMapper.readTree(response);
        JsonNode movieInfo = root.path("movieInfoResult").path("movieInfo");

        //영화 정보 매핑
        MovieDAO movieDAO = new MovieDAO(movieInfo.path("movieCd").asText(),
                movieInfo.path("movieNm").asText());

        //배우 리스트 매핑
        List<ActorDAO> actorDAOList = new ArrayList<>();
        for (JsonNode actorNode : movieInfo.path("actors")) {
            ActorDAO actorDAO = new ActorDAO(actorNode.path("peopleCd").asText(),
                    actorNode.path("peopleNm").asText(),
                    movieDAO); // 1:N 관계 설정
            actorDAOList.add(actorDAO);
        }

        // 영화와 배우 저장
        movieDAO.setActorList(actorDAOList);
        movieDAORepository.save(movieDAO);
        actorDAORepository.saveAll(actorDAOList);

        return new Movie(movieDAO);
    }

    //영화 조회
    public Movie getMovieActors(Long movieId) {
        return movieDAORepository.findById(movieId)
                .map(Movie::new)
                .orElse(null);
    }

    //배우 조회
    public Actor getActorMovies(Long actorId) {
        return actorDAORepository.findById(actorId)
                .map(Actor::new)
                .orElse(null);
    }
}
