package org.brainacademy.controller.form;

import java.time.LocalDate;

public class BatteryForm {

    private String serialNumber;
    private String model;
    private String ups;
    private LocalDate dateFactory;
    private boolean isBroken;

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(final String model)
    {
        this.model = model;
    }

    public String getUps()
    {
        return ups;
    }

    public void setUps(final String ups)
    {
        this.ups = ups;
    }

    public LocalDate getDateFactory()
    {
        return dateFactory;
    }

    public void setDateFactory(final LocalDate dateFactory)
    {
        this.dateFactory = dateFactory;
    }

    public boolean isBroken()
    {
        return isBroken;
    }

    public void setBroken(final boolean broken)
    {
        isBroken = broken;
    }
}
