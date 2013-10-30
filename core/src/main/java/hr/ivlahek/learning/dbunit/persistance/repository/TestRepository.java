package hr.ivlahek.learning.dbunit.persistance.repository;

import hr.ivlahek.learning.dbunit.persistance.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivlahek
 */
public interface TestRepository extends JpaRepository<Test, Integer> {
}
