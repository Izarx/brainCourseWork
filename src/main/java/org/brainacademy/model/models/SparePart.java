package org.brainacademy.model.models;


import javax.persistence.*;

/**
 * Class for create table of spare part models and types
 */

@Entity
@Table (name = "spare_models", schema = "upsproject")
public class SparePart extends ModelOfEquipment {

    //FIELDS

    @Enumerated(EnumType.STRING)
    private SparePartTypes type;

    //CONSTRUCTOR

    public SparePart() {}

    //SETTERS & GETTERS

    public SparePartTypes getType() {
        return type;
    }

    public void setType(SparePartTypes type) {
        this.type = type;
    }
}
