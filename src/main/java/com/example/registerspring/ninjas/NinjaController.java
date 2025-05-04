package com.example.registerspring.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome page";
    }

    @PostMapping("/add")
    public String createNinja() {
        return "Ninja Created";
    }

    @GetMapping("/all")
    public List<NinjaModel> showAllNinja() {
        return ninjaService.listNinjas();
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