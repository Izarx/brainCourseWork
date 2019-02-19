package org.brainacademy.model;

import org.brainacademy.model.api.Cabinet;
import org.brainacademy.model.upses.UpsImpl;

import javax.persistence.*;
import java.util.Set;

/**
 * This is our class for create some Enterprises in our holding. It extends from Cabinet, because we can remove UPS from
 * it or can invite one.
 */

@Entity
@Table (name = "enterprises", schema = "upsproject")
public class Enterprise implements Cabinet {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.enterprises_seq")
    @SequenceGenerator(name = "upsproject.enterprises_seq", sequenceName = "upsproject.enterprises_seq", allocationSize = 1)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @OneToMany(mappedBy = "ups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UpsImpl> upsImpls;

    //CONSTRUCTORS


    public Enterprise() {}

    public Enterprise(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
