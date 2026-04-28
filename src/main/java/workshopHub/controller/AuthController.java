package workshopHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import workshopHub.entity.User;
import workshopHub.repository.UserRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return repo.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null &&
            existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(existingUser);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body("Invalid email or password.");
    }
}