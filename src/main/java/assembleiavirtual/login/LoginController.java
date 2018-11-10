package assembleiavirtual.login;

import assembleiavirtual.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseEntity<Void> login(@RequestBody User user) {
        if (loginService.login(user.getEmail(), user.getPasswordHash())) {
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }

}
