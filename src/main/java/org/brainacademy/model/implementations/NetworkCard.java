package org.brainacademy.model.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.brainacademy.model.models.SparePart;
import javax.persistence.*;

/**
 * Class to create examples of Network cards witch will be the rows in the table "network_cards" in DB
 * @author Ihor Zakharko
 */

@Entity
@Table(name = "network_cards", schema = "joined")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NetworkCard extends EquipmentImplementation {

    //FIELDS

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_model", nullable = false)
    @JsonIgnore
    private SparePart model;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
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
}
