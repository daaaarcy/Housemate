package com.housemate.android;


public class ProfileEntry
{
    private String name;
    private double amount;

    public ProfileEntry(String name, double amount)
    {
        super();
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }
}
