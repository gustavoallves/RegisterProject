package com.example.registerspring.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome page";
    }

    @PostMapping("/add")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<UserModel> showAllUser() {
        return userService.listUser();
    }

    @GetMapping("/user/{id}")
    public UserModel findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/edit")
    public String editUser() {
        return "User edited";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}