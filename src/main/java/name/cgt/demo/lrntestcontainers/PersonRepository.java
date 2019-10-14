package name.cgt.demo.lrntestcontainers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByName(String name);
}
