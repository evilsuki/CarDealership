package org.yearup.dataModels;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();


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
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel (String make, String model)
    {
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getMake().equalsIgnoreCase(make))
            {
                inventory.add(vehicle);
            }
            else if (vehicle.getModel().equalsIgnoreCase(model))
            {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public ArrayList<Vehicle> getAllVehicles ()
    {
        return inventory;
    }

    public void addVehicle()
    {
       
    }

    public void displayVehicle(Vehicle vehicle)
    {
        System.out.printf("%-10d %-10d %-10s %-10s %-10s %-10s %-20d $ %.2f \n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
    }
}
