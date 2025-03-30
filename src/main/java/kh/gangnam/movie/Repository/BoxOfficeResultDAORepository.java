package kh.gangnam.movie.Repository;

import kh.gangnam.movie.Model.OpenApiDAO.BoxOfficeResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoxOfficeResultDAORepository extends JpaRepository<BoxOfficeResultDAO, Long> {
    Optional<BoxOfficeResultDAO> findByShowDate(String showDate);
}
