package assembleiavirtual.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseEntity<Void> login(String email, String passwordHash) {
        if (loginService.login(email, passwordHash)) {
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }

}
