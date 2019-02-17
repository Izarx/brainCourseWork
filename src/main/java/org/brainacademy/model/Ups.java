package org.brainacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Class to create table of UPS models
 */

@Entity
@Table (name = "upses", schema = "upsproject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ups implements Cabinet, Removable {

    //FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upsproject.upses_seq")
    @SequenceGenerator(name = "upsproject.upses_seq", sequenceName = "upsproject.upses_seq", allocationSize = 1)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    @Enumerated(EnumType.STRING)
    private UpsTypes type;

    @OneToMany(mappedBy = "ups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UpsImpl> upsImpls;

    //CONSTRUCTORS


    public Ups() {
    }

    public Ups(String name, Double price, UpsTypes type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    //SETTERS & GETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UpsTypes getType() {
        return type;
    }

    public void setType(UpsTypes type) {
        this.type = type;
    }

    public Set<UpsImpl> getUpsImpls() {
        return upsImpls;
    }

    public void setUpsImpls(Set<UpsImpl> upsImpls) {
        this.upsImpls = upsImpls;
    }
}
