package name.cgt.demo.lrntestcontainers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
class WithContainerizedDatabaseTest {
    @Container
    private static final MariaDBContainer DB_CONTAINER = new MariaDBContainer();

    @Test
    void starts_MariaDB_container() {
        assertThat(DB_CONTAINER.isRunning())
            .as("MariaDB container is running")
            .isTrue();
    }
}
