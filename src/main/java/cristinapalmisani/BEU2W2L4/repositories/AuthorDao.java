package cristinapalmisani.BEU2W2L4.repositories;

import cristinapalmisani.BEU2W2L4.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorDao extends JpaRepository<Author, UUID> {
}
