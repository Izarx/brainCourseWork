package org.brainacademy.model.models;


import javax.persistence.*;

/**
 * Class for create table of spare part models and types
 */

@Entity
@Table (name = "spare_models", schema = "upsproject")
public class SparePart extends ModelOfEquipment {

    //FIELDS

    @Column
    @Enumerated(EnumType.STRING)
    private SparePartsTypes type;

    //CONSTRUCTOR

    public SparePart() {}

    //SETTERS & GETTERS

    public SparePartsTypes getType() {
        return type;
    }

    public void setType(SparePartsTypes type) {
        this.type = type;
    }
}
