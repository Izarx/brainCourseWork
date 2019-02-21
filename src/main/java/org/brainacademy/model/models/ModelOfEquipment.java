package org.brainacademy.model.models;

import org.brainacademy.model.ProjectEntity;

import javax.persistence.*;

/**
 * Abstract class for models of equipment (UPS, Battery, Network Card, etc.)
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ModelOfEquipment extends ProjectEntity {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.models_seq")
    @SequenceGenerator(name = "upsproject.models_seq", sequenceName = "upsproject.models_seq", allocationSize = 1)
    private Long id;

    private String name;

    private Double price;

    //GETTERS & SETTERS

    public Long getId() { return id; }

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

    @Override
    public String toString() {
        return "ModelOfEquipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
