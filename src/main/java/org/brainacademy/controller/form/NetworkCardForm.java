package org.brainacademy.controller.form;

public class NetworkCardForm {

    private String name;
    private String serialNumber;
    private String sparePart;
    private String ups;
    private Boolean isBroken;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSparePart()
    {
        return sparePart;
    }

    public void setSparePart(final String sparePart)
    {
        this.sparePart = sparePart;
    }

    public String getUps()
    {
        return ups;
    }

    public void setUps(final String ups)
    {
        this.ups = ups;
    }

    public Boolean getIsBroken()
    {
        return isBroken;
    }

    public void setIsBroken(final Boolean broken)
    {
        isBroken = broken;
    }
}
