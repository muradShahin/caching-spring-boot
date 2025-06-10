package mtech.prokect.demopostgressapp;


import mtech.prokect.demopostgressapp.repositories.UserRepository;
import mtech.prokect.demopostgressapp.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class DemoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody Users user) {

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);


    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(true,HttpStatus.OK);

    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam long id) {

        var user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserEmail(@PathVariable long id,@RequestParam String email){
        return new ResponseEntity<>(userService.updateUserEmail(id,email),HttpStatus.OK);

    }


}
