package com.example.mvcdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.MessageFormat;
import java.time.LocalDate;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer actorId;

    private String firstName;
    private String lastName;
    private LocalDate lastUpdate;

    protected Actor() {
    }

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Actor[actorId={0}, lastName={1}, firstName={2}]", actorId, lastName, firstName);
    }
}
