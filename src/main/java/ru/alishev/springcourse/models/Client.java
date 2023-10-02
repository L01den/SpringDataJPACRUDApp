package ru.alishev.springcourse.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ClientId;
    @Column
    private String authorName;
    @Column(name = "year_of_writing")
    private int Birthday;
    @Column
    private String Document;

    @Column
    private String SurName;

    @Column
    private String FirstName;
    @Column
    private String Patronymic;


    public Client() {

    }

    public Client(int clientId, String authorName, int birthday, String document, String surName, String firstName, String patronymic) {
        ClientId = clientId;
        this.authorName = authorName;
        Birthday = birthday;
        Document = document;
        SurName = surName;
        FirstName = firstName;
        Patronymic = patronymic;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBirthday() {
        return Birthday;
    }

    public void setBirthday(int birthday) {
        Birthday = birthday;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }
}