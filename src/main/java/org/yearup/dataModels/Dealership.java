package org.yearup.dataModels;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    DealershipFileManager dealershipFileManager = new DealershipFileManager();
    ArrayList<Vehicle> vehicles = dealershipFileManager.loadVehicle();


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
        ArrayList<Vehicle> selectedInventory = new ArrayList<>();

        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                selectedInventory.add(vehicle);
            }
        }
        return selectedInventory;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel (String make, String model)
    {
        ArrayList<Vehicle> selectedInventory = new ArrayList<>();

        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getMake().equalsIgnoreCase(make))
            {
                selectedInventory.add(vehicle);
            }
            else if (vehicle.getModel().equalsIgnoreCase(model))
            {
                selectedInventory.add(vehicle);
            }
        }
        return selectedInventory;
    }

    public ArrayList<Vehicle> getAllVehicles()
    {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }
}
