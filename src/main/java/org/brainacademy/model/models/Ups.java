package org.brainacademy.model.models;

import org.brainacademy.model.api.Cabinet;
import org.brainacademy.model.api.Removable;

import javax.persistence.*;

/**
 * Class to create table of UPS models
 */

@Entity
@Table (name = "upses", schema = "upsproject")
public class Ups extends ModelOfEquipment {

    //FIELDS

    @Column
    @Enumerated(EnumType.STRING)
    private UpsTypes type;

    //CONSTRUCTOR

    public Ups() {}

    //SETTERS & GETTERS

    public UpsTypes getType() {
        return type;
    }

    public void setType(UpsTypes type) {
        this.type = type;
    }



}
