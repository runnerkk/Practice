package kh.gangnam.movie.Repository;

import kh.gangnam.movie.Model.OpenApiDAO.MovieDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAORepository extends JpaRepository<MovieDAO, Long> {
}
