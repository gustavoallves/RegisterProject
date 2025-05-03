package com.example.registerspring.mission;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mission")
public class MissionController {

//  GET -- Mandar requisicao para EXIBIR
    @GetMapping("/all")
    public String allMissions(){
        return "All missions";
    }

//  POST -- Mandar requisicao para CRIAR
    @PostMapping("/create")
    public String createMission(){
        return "Mission created";
    }

//  PUT -- Mandar requisicao para ALTERAR
    @PutMapping("/edit")
    public String editMission(){
        return "Mission edited";
    }

//  DELETE -- Mandar requisicao para DELETAR
    @DeleteMapping("/delete")
    public String deleteMission(){
        return "Mission deleted";
    }

}
