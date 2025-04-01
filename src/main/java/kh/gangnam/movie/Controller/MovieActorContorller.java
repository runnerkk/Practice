package kh.gangnam.movie.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kh.gangnam.movie.Model.OpenApiDTO.Actor;
import kh.gangnam.movie.Model.OpenApiDTO.Movie;
import kh.gangnam.movie.Service.MovieActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movieactor")
public class MovieActorContorller {

    private final MovieActorService movieActorService;

    //영화, 배우정보 저장
    @PostMapping("/save/{movieCd}")
    public ResponseEntity<Movie> saveMovieActors(@PathVariable String movieCd) throws JsonProcessingException {
        Movie saveMovie = movieActorService.saveMovieActors(movieCd);
        return ResponseEntity.ok(saveMovie);
    }

    //영화 조회(배우포함)
    @GetMapping("/{movieCd}")
    public ResponseEntity<Movie> getMovieActors(@PathVariable Long movieId) {
        Movie movie = movieActorService.getMovieActors(movieId);
        return movie != null? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    @GetMapping("/actor/{actorId}")
    public ResponseEntity<Actor> getActorMovies(@PathVariable Long actorId) {
        Actor actor = movieActorService.getActorMovies(actorId);
        return actor != null ? ResponseEntity.ok(actor) : ResponseEntity.notFound().build();
    }
}
