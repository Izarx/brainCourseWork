package org.brainacad.model;

import javax.persistence.*;

/**
 * Class to create table of UPS models
 */

@Entity
@Table (name = "ups_models", schema = "upsproject")

public class Ups implements Cabinet, Removable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.upses_seq")
    @SequenceGenerator(name = "upsproject.upses_seq", sequenceName = "upsproject.upses_seq", allocationSize = 1)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    @Enumerated(EnumType.STRING)
    private UpsTypes type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UpsTypes getType() {
        return type;
    }

    public void setType(UpsTypes type) {
        this.type = type;
    }
}
