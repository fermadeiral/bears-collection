package assembleiavirtual.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserRepository userRepository;

    private Integer insertedId;

    @Before
    public void setup() {
        User user = new User.Builder()
                .withEmail("email@email.email")
                .withPasswordHash("ABCD1234")
                .build();

        entityManager.persist(user);
        insertedId = user.getId();
    }

    @Test
    public void testFindByIdInvalid() {
        User user = userRepository.findByEmailAndPasswordHash("email@email.email", "WRONG_PASSWORD_HASH");

        assertThat(user).isNull();
    }

    @Test
    public void testFindByIdValid() {
        User user = userRepository.findByEmailAndPasswordHash("email@email.email", "ABCD1234");

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(insertedId);
        assertThat(user.getEmail()).isEqualTo("email@email.email");
        assertThat(user.getPasswordHash()).isEqualTo("ABCD1234");
    }

}
