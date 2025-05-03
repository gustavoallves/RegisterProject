package com.example.registerspring.ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome page";
    }

    @PostMapping("/add")
    public String createNinja() {
        return "Ninja Created";
    }

    @GetMapping("/all")
    public String showAllNinja() {
        return "All Ninjas";
    }

    @GetMapping("/allById")
    public String showAllNinjaById() {
        return "All Ninjas by Id";
    }

    @PutMapping("/edit")
    public String editNinja() {
        return "Ninja edited";
    }

    @DeleteMapping("/delete")
    public String deleteNinja() {
        return "Ninja deleted";
    }

}
