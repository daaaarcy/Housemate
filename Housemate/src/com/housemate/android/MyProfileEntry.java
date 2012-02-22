package com.housemate.android;


public class MyProfileEntry
{
    private String name;
    private float amount;
    
    public MyProfileEntry(String name, float amount)
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

    public float getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }
}
