package org.yearup.dataModels;

import java.io.*;

public class DealershipFileManager
{
    public Dealership getDealership()
    {
        FileReader fileReader;
        BufferedReader reader = null;

        try
        {
            fileReader = new FileReader("inventory.csv");
            reader = new BufferedReader(fileReader);
            String line;

            String[] variable1 = reader.readLine().split("\\|");
            String name = variable1[0];
            String address = variable1[1];
            String phone = variable1[2];

            Dealership dealership = new Dealership(name, address, phone);

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
                dealership.addVehicle(vehicle);
            }

            return dealership;
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
        return null;
    }


    public void saveDealership(Dealership dealership)
    {
        FileWriter fileWriter;
        BufferedWriter writer = null;

        try
        {
            fileWriter = new FileWriter("inventory.csv");
            writer = new BufferedWriter(fileWriter);

            fileWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

            for (Vehicle vehicle : dealership.vehicles)
            {
                fileWriter.write(vehicle.getVin() + "|" + vehicle.getYear()
                                + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                                + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor()
                                + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
