package com.cpc.backend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "pbs")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    Long id;
    @Column
    String title;
    @Column
    String description;

    public Problem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Problem() {
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
