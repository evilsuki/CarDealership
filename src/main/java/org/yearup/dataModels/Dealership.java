package org.yearup.dataModels;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> vehicles;


    public Dealership (String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice (double max, double min)
    {

        return ;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel (String make, String model)
    {

        return ;
    }

    public ArrayList<Vehicle> getAllVehicles ()
    {

        return ;
    }

    public void addVehicle()
    {

    }
}
