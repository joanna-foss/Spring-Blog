package com.codeup.springblog.controllers.lecture;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany
    private List<Car> vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Car> vehicle) {
        this.vehicle = vehicle;
    }
}