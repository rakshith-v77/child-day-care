package com.example.daycare.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String parentName;

    private String parentContact;

    private LocalDate enrolledDate;

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentContact() {
        return parentContact;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    public void setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
    }
}
