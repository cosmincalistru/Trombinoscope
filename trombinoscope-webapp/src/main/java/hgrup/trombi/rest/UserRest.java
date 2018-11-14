package hgrup.trombi.rest;

import hgrup.trombi.entity.User;
import hgrup.trombi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserRest {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> all() {
        return userService.list();
    }

}
