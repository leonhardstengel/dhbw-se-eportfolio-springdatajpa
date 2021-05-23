package com.se.eportfoliojpa.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
public class EPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eportfolioId")
    @NotNull
    private int id;

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "presenter")
    @NotNull
    private Student presenter;

    @ManyToMany
    @JoinTable(name = "listeners",
            joinColumns = @JoinColumn(name = "eportfolioId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    @NotNull
    private List<Student> listeners = new ArrayList<Student>();

    @NotNull
    private Date date;

    public EPortfolio(String title, Student presenter, List<Student> listeners, Date date) {
        this.title = title;
        this.presenter = presenter;
        this.listeners = listeners;
        this.date = date;
    }

    public EPortfolio() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getPresenter() {
        return presenter;
    }

    public void setPresenter(Student presenter) {
        this.presenter = presenter;
    }

    public List<Student> getListeners() {
        return listeners;
    }

    public void setListeners(List<Student> listeners) {
        this.listeners = listeners;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s, presenter: %s", this.getId(), this.getTitle(), this.getPresenter().getName());
    }
}
