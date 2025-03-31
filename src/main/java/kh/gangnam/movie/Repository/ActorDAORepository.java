package kh.gangnam.movie.Repository;

import kh.gangnam.movie.Model.OpenApiDAO.ActorDAO;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ActorDAORepository extends JpaRepository<ActorDAO, Long> {
}
