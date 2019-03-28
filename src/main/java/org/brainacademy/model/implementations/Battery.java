package org.brainacademy.model.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.models.SparePart;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class to create examples of Batteries witch will be the rows in the table "batteries" in DB
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
    private SparePart model;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_ups", nullable = false)
    @JsonIgnore
    private UpsImpl ups;

    @Column(name = "date_factory")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFactory;

    //CONSTRUCTOR

    public Battery() {}

    //GETTERS & SETTERS

    public SparePart getModel() {
        return model;
    }

    public void setModel(SparePart model) {
        this.model = model;
    }

    public UpsImpl getUps() {
        return ups;
    }

    public void setUps(UpsImpl ups) {
        this.ups = ups;
    }

    public LocalDate getDateFactory() {
        return dateFactory;
    }

    public void setDateFactory(LocalDate dateFactory) {
        this.dateFactory = dateFactory;
    }
}
