package org.brainacademy.model.implementations;

import org.brainacademy.model.ProjectEntity;
import org.brainacademy.model.api.Removable;

import javax.persistence.*;

/**
 * Abstract class produce implementation of equipment
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EquipmentImplementation extends ProjectEntity implements Removable {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "is_broken")
    private Boolean isBroken;

    //GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getBroken() {
        return isBroken;
    }

    public void setBroken(Boolean broken) {
        isBroken = broken;
    }
}
