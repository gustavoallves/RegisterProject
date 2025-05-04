package com.example.registerspring.mission;

import com.example.registerspring.ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String difficulty;

    // One mission has many ninjas
    @OneToMany(mappedBy = "mission") //Created Foreign Key
    @JsonIgnore
    private List<NinjaModel> ninja;

    public MissionModel() {
    }

    public MissionModel(String description, String difficulty, List<NinjaModel> ninja) {
        this.description = description;
        this.difficulty = difficulty;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String missionDifficulty) {
        this.difficulty = missionDifficulty;
    }

    public List<NinjaModel> getNinja() {
        return ninja;
    }

    public void setNinja(List<NinjaModel> ninja) {
        this.ninja = ninja;
    }
}