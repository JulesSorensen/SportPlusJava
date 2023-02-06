package project.SportPlus.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import project.SportPlus.pojo.User;
import project.SportPlus.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserWs {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        System.out.println(user);
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user,
                           @PathVariable("id") Long id){
        userService.updateUser(user,id);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
