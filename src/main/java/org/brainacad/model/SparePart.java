package org.brainacad.model;

import javax.persistence.*;

/**
 * Class for create table of spare part models and types
 */

@Entity
@Table (name = "spare_models", schema = "upsproject")
public class SparePart implements Removable {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.spare_parts_seq")
    @SequenceGenerator(name = "upsproject.spare_parts_seq", sequenceName = "upsproject.spare_parts_seq", allocationSize = 1)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    @Enumerated(EnumType.STRING)
    private SparePartsTypes type;

    //CONSTRUCTORS


    public SparePart() {}

    public SparePart(String name, Double price, SparePartsTypes type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    //SETTERS & GETTERS

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

    public SparePartsTypes getType() {
        return type;
    }

    public void setType(SparePartsTypes type) {
        this.type = type;
    }
}
