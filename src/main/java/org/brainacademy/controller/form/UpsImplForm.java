package org.brainacademy.controller.form;

public class UpsImplForm {

    private String name;
    private String serialNumber;
    private Boolean isBroken;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getBroken() {
        return isBroken;
    }

    public void setBroken(Boolean broken) {
        isBroken = broken;
    }
}
