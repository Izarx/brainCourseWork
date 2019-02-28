package org.brainacademy.model.implementations;

import org.brainacademy.model.ProjectEntity;
import org.brainacademy.model.api.Removable;

import javax.persistence.*;

/**
 * Abstract class produce implementation of equipment
 * @author Ihor Zakharko
 */


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "implementations", schema = "joined")
public abstract class EquipmentImplementation extends ProjectEntity implements Removable {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "is_broken")
    private boolean isBroken;

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

    public boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(boolean broken) {
        isBroken = broken;
    }

    // OVERRIDING METHODS

    @Override
    public String toString() {
        return "EquipmentImplementation{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", isBroken=" + isBroken +
                '}';
    }
}
