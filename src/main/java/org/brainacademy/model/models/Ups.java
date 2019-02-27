package org.brainacademy.model.models;

import org.brainacademy.model.implementations.UpsImpl;

import javax.persistence.*;
import java.util.Set;

/**
 * Class to create table of UPS models
 */

@Entity
@Table (name = "upses", schema = "joined")
public class Ups extends ModelOfEquipment {

    //FIELDS

    @Enumerated(EnumType.STRING)
    private UpsTypes type;

    /*@OneToMany(mappedBy = "ups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UpsImpl> upsImplSet;*/

    //CONSTRUCTOR

    public Ups() {}

    //SETTERS & GETTERS

    public UpsTypes getType() {
        return type;
    }

    public void setType(UpsTypes type) {
        this.type = type;
    }

    /*public Set<UpsImpl> getUpsSet() {
        return upsImplSet;
    }

    public void setUpsSet(Set<UpsImpl> upsImplSet) {
        this.upsImplSet = upsImplSet;
    }*/
}
