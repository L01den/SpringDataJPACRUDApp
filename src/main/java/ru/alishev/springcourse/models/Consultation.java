package ru.alishev.springcourse.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ConsultationId;
    @Column
    private int ClientId;
    @Column
    private int PetId;
    @Column
    private LocalDate ConsultationDate;
    @Column
    private String Description;

    public Consultation(int consultationId, int clientId, int petId, LocalDate consultationDate, String description) {
        ConsultationId = consultationId;
        ClientId = clientId;
        PetId = petId;
        ConsultationDate = consultationDate;
        Description = description;
    }

    public int getConsultationId() {
        return ConsultationId;
    }

    public void setConsultationId(int consultationId) {
        ConsultationId = consultationId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getPetId() {
        return PetId;
    }

    public void setPetId(int petId) {
        PetId = petId;
    }

    public LocalDate getConsultationDate() {
        return ConsultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        ConsultationDate = consultationDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
