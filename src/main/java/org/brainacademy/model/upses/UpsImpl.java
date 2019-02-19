package org.brainacademy.model.upses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.Enterprise;
import org.brainacademy.model.upses.Ups;

import javax.persistence.*;

/**
 * Class for create example of UPS which has some model, get one from upses
 */

@Entity
@Table(name = "upses_impl", schema = "upsproject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UpsImpl extends Ups {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_model", nullable = false)
    @JsonIgnore
    private Ups ups;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enterprise", nullable = false)
    @JsonIgnore
    private Enterprise enterprise;

    @Column(name = "is_broken")
    private Boolean isBroken;

    //CONSTRUCTORS

    public UpsImpl() {}

    public UpsImpl(String name, String serialNumber, Ups ups, Enterprise enterprise) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.ups = ups;
        this.enterprise = enterprise;
        this.isBroken = false;
    }

    //SETTERS & GETTERS


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Ups getUps() {
        return ups;
    }

    public void setUps(Ups ups) {
        this.ups = ups;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Boolean getBroken() {
        return isBroken;
    }

    public void setBroken(Boolean broken) {
        isBroken = broken;
    }
}
