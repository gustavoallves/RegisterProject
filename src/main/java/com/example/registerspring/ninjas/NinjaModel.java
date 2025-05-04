package com.example.registerspring.ninjas;

import com.example.registerspring.mission.MissionModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_register")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    // Many ninjas have one mission
    @ManyToOne
    @JoinColumn(name = "mission_id") // Added Table of Foreign Key
    private MissionModel mission;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age, MissionModel mission) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.mission = mission;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MissionModel getMission() {
        return mission;
    }

    public void setMission(MissionModel mission) {
        this.mission = mission;
    }

}
