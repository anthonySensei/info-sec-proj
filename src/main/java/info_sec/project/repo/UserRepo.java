package info_sec.project.repo;

import info_sec.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findById(Long id);

    @Modifying
    @Query(value = "insert into roles values (:id, 'ADMIN')", nativeQuery = true)
    @Transactional
    void makeAdmin(@Param("id") Long id);
}
