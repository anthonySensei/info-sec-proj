package info_sec.project.repo;

import info_sec.project.model.Curator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CuratorRepo extends JpaRepository<Curator, String> {
    Curator findById(Long id);

    @Transactional
    void deleteById(Long id);
}
