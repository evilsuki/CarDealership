package org.yearup.dataModels;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory;

    public Dealership (String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    
}
