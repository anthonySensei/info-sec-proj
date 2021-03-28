package info_sec.project.contoller;

import info_sec.project.model.Role;
import info_sec.project.model.User;
import info_sec.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users", produces = "application/json")
    List<User> getUsers() {
        return userRepo.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users/{id}", produces = "application/json")
    User getUser(@PathVariable Long id) {
        return userRepo.findById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping(value = "/users/{id}", produces = "application/json")
    User makeAdmin(@PathVariable Long id) {
        User user = userRepo.findById(id);

        if (user == null) {
            return null;
        }

        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepo.makeAdmin(id);
        return user;
    }
}
