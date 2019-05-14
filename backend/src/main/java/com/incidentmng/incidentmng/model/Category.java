package com.incidentmng.incidentmng.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "category_seq" )
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    private long id;

    @Column(name = "category")
    @NotNull
    private String category;

    public Category() {
    }

    public Category(@NotNull String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
