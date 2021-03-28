package info_sec.project.contoller;

import info_sec.project.model.Auth;
import info_sec.project.model.User;
import info_sec.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/login", produces = "application/json")
    public String login(@RequestBody Auth auth) {
        String username = auth.getUsername();
        String password = auth.getPassword();
        String loginErrorMessage = "{\"message\": \"Bad credentials\"}";
        UserDetails user = userService.loadUserByUsername(username);

        if (user == null) {
            return loginErrorMessage;
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return loginErrorMessage;
        }

        String token = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        return "{\"message\": \"User has been successfully login\", \"token\":\"" + token + "\"}";
    }

    @PostMapping(value = "/registration", produces = "application/json")
    public String registration(@RequestBody User user) {

        if (!userService.createUser(user)) {
            return "{ \"message\": \"User exists\"}";
        }

        return "{\"message\": \"User has been successfully created\"}";
    }

}
