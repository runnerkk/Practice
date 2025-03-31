package kh.gangnam.movie.Service;

import kh.gangnam.movie.Model.OpenApiDAO.ActorDAO;
import kh.gangnam.movie.Model.OpenApiDAO.MovieDAO;
import kh.gangnam.movie.Model.OpenApiDTO.Movie;
import kh.gangnam.movie.Repository.ActorDAORepository;
import kh.gangnam.movie.Repository.MovieDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieActorService {

    private final MovieDAORepository movieDAORepository;
    private final ActorDAORepository actorDAORepository;

    //영화와 배우 db에 저장
    public void saveMovieActors(Movie movie) {
        MovieDAO movieDAO = new MovieDAO();
        movieDAO.set
    }
}
