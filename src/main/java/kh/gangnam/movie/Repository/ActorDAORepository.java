package kh.gangnam.movie.Repository;

import kh.gangnam.movie.Model.OpenApiDAO.ActorDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDAORepository extends JpaRepository<ActorDAO, Long> {
}
