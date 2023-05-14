package org.yearup.dataModels;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    Scanner scanner =new Scanner(System.in);
    ArrayList<Dealership> vehicles;
    private Dealership dealership;


    private void init()
    {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.vehicles = dealershipFileManager.getDealership();
    }


    public void display()
    {
        try
        {
            while (true)
            {
                int selection = displayMenu();

                if (selection == 1)
                {
                    processGetByPriceRequest();
                }
                else if (selection == 2)
                {
                    processGetByMakeModelRequest();
                }
                else if (selection == 3)
                {
                    processGetAllVehicleRequest();
                }
                else if (selection == 4)
                {
                    processAddVehicleRequest();
                }
                else if (selection == 0)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid selection");
                    System.out.println();
                    displayMenu();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

     private int displayMenu()
     {
         System.out.println();
         System.out.println("===========================================================================================");
         System.out.println("Menu");
         System.out.println("-------------------------------------------------------------------------------------------");
         System.out.println("What do you like to do?");
         System.out.println("\t 1) Find vehicles within a price range");
         System.out.println("\t 2) Find vehicles by make/model");
         System.out.println("\t 3) List All vehicles");
         System.out.println("\t 4) Add a vehicle");
         System.out.println("\t 0) Quit");
         System.out.print("Enter your selection: ");
         int selection = scanner.nextInt();
         scanner.nextLine();
         return selection;
     }

    public void processGetByPriceRequest()
    {
        System.out.println();
        System.out.println("===========================================================================================");
        System.out.println();
        System.out.print("Enter the minimum price: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (Dealership vehicle : vehicles)
        {
            displayVehicles(vehicle.getVehiclesByPrice(max, min));
        }


    }

    public void processGetByMakeModelRequest()
    {
        System.out.println();
        System.out.println("===========================================================================================");
        System.out.println();
        System.out.print("Enter the make of vehicle: ");
        String make = scanner.nextLine().strip();
        System.out.print("Enter the model of vehicle: ");
        String model = scanner.nextLine().strip();
        scanner.nextLine();

        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (Dealership vehicle : vehicles)
        {
            displayVehicles(vehicle.getVehiclesByMakeModel(make, model));
        }
    }

    public void processGetAllVehicleRequest()
    {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest()
    {

    }

    public void displayVehicles(ArrayList<Vehicle> vehicles)
    {
        StringBuilder result = new StringBuilder();
        if (vehicles.size() == 0)
        {
            result = new StringBuilder("No vehicles found in inventory.\n");
        }
        else
        {
            // Table header
            result.append(String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-20s %s \n", "VIN", "Year", "Make", "Model", "Vehicle Type", "Color", "Odometer", "Price"));
            result.append("-------------------------------------------------------------------------------------------\n");

            // Table rows
            for (Vehicle vehicle : vehicles)
            {
                result.append(String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-20d $ %.2f \n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }
        }
        System.out.println(result);
    }
}
