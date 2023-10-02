package ru.alishev.springcourse.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int PetId;
    @Column
    public int ClientId;
    @Column
    public String Name;
    @Column
    public LocalDate Birthday;

    public Pet(int petId, int clientId, String name, LocalDate birthday) {
        PetId = petId;
        ClientId = clientId;
        Name = name;
        Birthday = birthday;
    }

    public int getPetId() {
        return PetId;
    }

    public void setPetId(int petId) {
        PetId = petId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }
}
