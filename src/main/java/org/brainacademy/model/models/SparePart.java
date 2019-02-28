package org.brainacademy.model.models;


import javax.persistence.*;

/**
 * Class for create table of spare part models and types
 * @author Ihor Zakharko
 */

@Entity
@Table (name = "spare_parts", schema = "joined")
public class SparePart extends ModelEquipment {

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
