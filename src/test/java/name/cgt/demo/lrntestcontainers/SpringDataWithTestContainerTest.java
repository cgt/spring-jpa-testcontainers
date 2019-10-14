package name.cgt.demo.lrntestcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class SpringDataWithTestContainerTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void context_loads() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void given_empty_database_findAll_returns_empty_collection() {
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    public void person_gets_id_when_saved() {
        var person = new Person("Alice", LocalDate.of(1999, Month.JANUARY, 1));

        assertThat(person.getId()).isNull();
        person = repository.save(person);
        assertThat(person.getId()).isNotNull();
    }

    @Test
    public void find_person_by_name() {
        final var myAlice = repository.save(new Person("Alice", LocalDate.of(1999, Month.JANUARY, 1)));

        final var peopleNamedAlice = repository.findAllByName("Alice");

        assertThat(peopleNamedAlice).contains(myAlice);
    }
}
