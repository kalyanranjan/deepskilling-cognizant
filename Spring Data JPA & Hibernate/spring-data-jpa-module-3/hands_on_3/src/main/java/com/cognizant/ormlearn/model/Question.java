package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "qt_id")
    private int id;

    @Column(name = "qt_text")
    private String text;

    @OneToMany(mappedBy = "question")
    private Set<Options> optionsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(Set<Options> optionsList) {
        this.optionsList = optionsList;
    }
}
