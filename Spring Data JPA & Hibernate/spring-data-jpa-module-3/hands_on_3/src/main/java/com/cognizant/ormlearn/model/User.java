package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Attempt> attemptList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Attempt> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(Set<Attempt> attemptList) {
        this.attemptList = attemptList;
    }
}
