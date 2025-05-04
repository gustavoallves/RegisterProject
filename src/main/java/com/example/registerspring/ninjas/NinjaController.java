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

    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    @GetMapping("/all")
    public List<NinjaModel> showAllNinja() {
        return ninjaService.listNinjas();
    }

    @GetMapping("/find/{id}")
    public NinjaModel findById(@PathVariable Long id) {
        return ninjaService.findById(id);
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