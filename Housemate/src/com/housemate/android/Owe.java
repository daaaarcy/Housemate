package com.housemate.android;


public class Owe
{
    private String name;
    private String title;
    private double amount;
    private boolean amILender;

    public Owe(String name, String title, double amount, boolean amILender)
    {
        this.name = name;
        this.title = title;
        this.amount = amount;
        this.amILender = amILender;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public double getAmount()
    {
        return amount;
    }

    public boolean getAmILender()
    {
        return amILender;
    }
}
