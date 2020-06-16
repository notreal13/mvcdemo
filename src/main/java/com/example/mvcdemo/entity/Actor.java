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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer actorId;

    private String firstName;
    private String lastName;
    private LocalDate lastUpdate;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
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

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Actor[actorId={0}, lastName={1}]", actorId, lastName);
    }
}
