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
    private SparePartType type;

    //CONSTRUCTOR

    public SparePart() {}

    //SETTERS & GETTERS

    public SparePartType getType() {
        return type;
    }

    public void setType(SparePartType type) {
        this.type = type;
    }
}
