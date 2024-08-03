package GoKapture.task.management.system.Controllers;

import GoKapture.task.management.system.DTOs.LoginRequest;
import GoKapture.task.management.system.Entities.User;
import GoKapture.task.management.system.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Registration successful");
//        }
//        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        User user = userService.findByUsername(loginRequest.getUsername());
//        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
        return ResponseEntity.ok("Login successful");
    }
}
