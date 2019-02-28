package org.brainacademy.model.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.models.SparePart;

import javax.persistence.*;
import java.util.Date;

/**
 * Class to create table with examples of batteries
 * @author Ihor Zakharko
 */

@Entity
@Table(name = "batteries", schema = "joined")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Battery extends EquipmentImplementation {

    //FIELDS

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_model", nullable = false)
    @JsonIgnore
    private SparePart sparePart;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_ups", nullable = false)
    @JsonIgnore
    private UpsImpl ups;

    @Column(name = "date_factory")
    @Temporal(TemporalType.DATE)
    private Date dateFactory;

    //CONSTRUCTOR

    public Battery() {}

    //GETTERS & SETTERS

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }

    public UpsImpl getUps() {
        return ups;
    }

    public void setUps(UpsImpl ups) {
        this.ups = ups;
    }

    public Date getDateFactory() {
        return dateFactory;
    }

    public void setDateFactory(Date dateFactory) {
        this.dateFactory = dateFactory;
    }
}
