package org.brainacademy.model.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.models.SparePart;

import javax.persistence.*;

@Entity
@Table(name = "network_cards", schema = "joined")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NetworkCard extends EquipmentImplementation {

    //FIELDS

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_model", nullable = false)
    @JsonIgnore
    private SparePart sparePart;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ups", nullable = false)
    @JsonIgnore
    private UpsImpl ups;

    //CONSTRUCTOR

    public NetworkCard() {}

    //GETTERS & SETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
