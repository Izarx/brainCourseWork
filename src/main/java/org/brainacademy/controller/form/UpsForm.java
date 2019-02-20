package org.brainacademy.controller.form;

import org.brainacademy.model.models.UpsTypes;

public class UpsForm {

    private String name;
    private Double price;
    private UpsTypes type;

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
}
