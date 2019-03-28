package org.brainacademy.controller.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BatteryForm {

    private String serialNumber;
    private String model;
    private String ups;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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

    public boolean getIsBroken()
    {
        return isBroken;
    }

    public void setIsBroken(final boolean isBroken)
    {
        this.isBroken = isBroken;
    }
}
