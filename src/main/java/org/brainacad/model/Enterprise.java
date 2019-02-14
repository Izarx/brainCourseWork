package org.brainacad.model;

import javax.persistence.*;

/**
 * This is our class for create some Enterprises in our holding. It extends from Cabinet, because we can remove UPS from
 * it or can invite one.
 */

public class Enterprise implements Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.enterprises_seq")
    @SequenceGenerator(name = "upsproject.enterprises_seq", sequenceName = "upsproject.enterprises_seq", allocationSize = 1)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String address;

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
