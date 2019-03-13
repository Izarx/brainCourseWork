package org.brainacademy.model.models;

import javax.persistence.*;

/**
 * Class to create table of UPS models
 * @author Ihor Zakharko
 */

@Entity
@Table (name = "upses", schema = "joined")
public class Ups extends ModelEquipment {

    //FIELDS

    @Enumerated(EnumType.STRING)
    private UpsType type;

    //CONSTRUCTOR

    public Ups() {}

    //SETTERS & GETTERS

    public UpsType getType() {
        return type;
    }

    public void setType(UpsType type) {
        this.type = type;
    }

}
