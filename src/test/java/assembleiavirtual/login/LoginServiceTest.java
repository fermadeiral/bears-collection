package assembleiavirtual.login;

import assembleiavirtual.user.User;
import assembleiavirtual.user.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LoginServiceTest {

    private static final String VALID_EMAIL = "email@email.com";
    private static final String VALID_PASSWORD_HASH = "ABCD1234";
    private static final String INVALID_EMAIL = "email@not.valid";
    private static final String INVALID_PASSWORD_HASH = "";

    @TestConfiguration
    static class LoginServiceTestContextConfiguration {
        @Bean
        public LoginService loginService() {
            return new LoginService();
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Before
    public void setup() {
        User user = new User.Builder()
                .withEmail(VALID_EMAIL)
                .withPasswordHash(VALID_PASSWORD_HASH)
                .build();

        when(userRepository.findByEmailAndPasswordHash(VALID_EMAIL, VALID_PASSWORD_HASH)).thenReturn(user);
    }

    @Test
    public void testInvalidEmailAndPasswordHash() {
        boolean validLogin = loginService.login(INVALID_EMAIL, INVALID_PASSWORD_HASH);

        assertFalse(validLogin);
    }

    @Test
    public void testInvalidEmail() {
        boolean validLogin = loginService.login(INVALID_EMAIL, VALID_PASSWORD_HASH);

        assertFalse(validLogin);
    }

    @Test
    public void testInvalidPasswordHash() {
        boolean validLogin = loginService.login(VALID_EMAIL, INVALID_PASSWORD_HASH);

        assertFalse(validLogin);
    }

    @Test
    public void testValidLogin() {
        boolean validLogin = loginService.login(VALID_EMAIL, VALID_PASSWORD_HASH);

        assertTrue(validLogin);
    }

}
