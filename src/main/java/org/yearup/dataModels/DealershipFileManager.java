package org.yearup.dataModels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager
{
    ArrayList<Vehicle> inventory = new ArrayList<>();
    ArrayList<Dealership> dealerships = new ArrayList<>();

    private ArrayList<Vehicle> vehicleList()
    {
        FileReader fileReader;
        BufferedReader reader = null;

        try
        {
            fileReader = new FileReader("inventory.csv");
            reader = new BufferedReader(fileReader);
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null)
            {
                String[] variable = line.split("\\|");
                int vin = Integer.parseInt(variable[0]);
                int year = Integer.parseInt(variable[1]);
                String make = variable[2];
                String model = variable[3];
                String vehicleType = variable[4];
                String color = variable[5];
                int odometer = Integer.parseInt(variable[6]);
                double price = Double.parseDouble(variable[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        return inventory;
    }


    public ArrayList<Dealership> getDealership()
    {
        FileReader fileReader;
        BufferedReader reader = null;

        try
        {
            fileReader = new FileReader("inventory.csv");
            reader = new BufferedReader(fileReader);

            String[] variable1 = reader.readLine().split("\\|");
            String name = variable1[0];
            String address = variable1[1];
            String phone = variable1[2];

            Dealership dealership = new Dealership(name, address, phone);
            dealerships.add(dealership);

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        return dealerships;
    }


    public void saveDealership()
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter("inventory.csv");

            for (Dealership dealership : dealerships)
            {
                fileWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            }

            for (Vehicle vehicle : inventory)
            {
                fileWriter.write(vehicle.getVin() + "|" + vehicle.getYear()
                                + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                                + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor()
                                + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
