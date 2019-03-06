package org.brainacademy.model;

import org.brainacademy.model.api.Cabinet;

import javax.persistence.*;

/**
 * This is our class for create some Enterprises in our holding. It extends from Cabinet, because we can remove UPS from
 * it or can invite one.
 */

@Entity
@Table (name = "enterprises", schema = "joined")
public class Enterprise extends ProjectEntity implements Cabinet {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String address;

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
