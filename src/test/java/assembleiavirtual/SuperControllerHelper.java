package assembleiavirtual;

import assembleiavirtual.login.LoginService;
import org.springframework.boot.test.mock.mockito.MockBean;

public abstract class SuperControllerHelper {

    @MockBean
    protected LoginService loginService;

}
