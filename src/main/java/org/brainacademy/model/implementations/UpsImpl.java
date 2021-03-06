package org.brainacademy.model.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.Enterprise;
import org.brainacademy.model.api.Cabinet;
import org.brainacademy.model.models.Ups;

import javax.persistence.*;

/**
 * Class to create examples of UPS witch will be the rows in the table "upses_impl" in DB
 * @author Ihor Zakharko
 */

@Entity
@Table(name = "upses_impl", schema = "joined")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UpsImpl extends EquipmentImplementation implements Cabinet {

    //FIELDS

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_model", nullable = false)
    @JsonIgnore
    private Ups ups;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_enterprise", nullable = false)
    @JsonIgnore
    private Enterprise enterprise;

    //CONSTRUCTORS

    public UpsImpl() {}

    //SETTERS & GETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
