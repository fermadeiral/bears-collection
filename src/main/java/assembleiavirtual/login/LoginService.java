package assembleiavirtual.login;

import assembleiavirtual.user.User;
import assembleiavirtual.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String passwordHash) {
        User user = userRepository.findByEmailAndPasswordHash(email, passwordHash);
        return user != null;
    }

}
