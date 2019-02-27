package org.brainacademy.model.models;

import org.brainacademy.model.ProjectEntity;

import javax.persistence.*;

/**
 * Abstract class for models of equipment (UPS, Battery, Network Card, etc.)
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "models", schema = "joined")
public abstract class ModelEquipment extends ProjectEntity {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    // OVERRIDING METHODS

    @Override
    public String toString() {
        return "ModelEquipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
