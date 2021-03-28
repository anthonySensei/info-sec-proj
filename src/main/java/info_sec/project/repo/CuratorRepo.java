package info_sec.project.repo;

import info_sec.project.model.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepo extends JpaRepository<Curator, String> {
    Curator findById(Long id);
}
