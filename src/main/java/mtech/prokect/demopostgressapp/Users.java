package mtech.prokect.demopostgressapp;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Column
    private String email;

    @Column
    private String occupation;


    public Long getId() {
        return id;
    }
}
