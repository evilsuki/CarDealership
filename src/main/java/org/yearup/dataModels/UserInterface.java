package org.yearup.dataModels;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    Scanner scanner =new Scanner(System.in);
    private final Dealership dealership;


    public UserInterface()
    {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
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
                    DealershipFileManager dealershipManager = new DealershipFileManager();
                    dealershipManager.saveDealership(dealership);
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
         System.out.println();
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

        System.out.println();
        System.out.println("Vehicle List");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-13s %s \n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("-------------------------------------------------------------------------------------------");

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(max, min);
        for (Vehicle vehicle : vehicles)
        {
            displayVehicle(vehicle);
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

        System.out.println();
        System.out.println("Vehicle List");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-13s %s \n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("-------------------------------------------------------------------------------------------");

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        for (Vehicle vehicle : vehicles)
        {
            displayVehicle(vehicle);
        }
    }

    public void processGetAllVehicleRequest()
    {
        System.out.println();
        System.out.println("===========================================================================================");
        System.out.println();
        System.out.println("Vehicle List");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-13s %s \n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("-------------------------------------------------------------------------------------------");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles)
        {
            displayVehicle(vehicle);
        }
    }

    public void processAddVehicleRequest()
    {
        System.out.println();
        System.out.println("===========================================================================================");
        System.out.println();
        System.out.print("Enter vehicle VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine().strip();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine().strip();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine().strip();
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine().strip();
        System.out.print("Enter vehicle odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
    }


    public void displayVehicle(Vehicle vehicle)
    {
        System.out.printf("%-10d %-10d %-10s %-10s %-10s %-10s %-13d $ %.2f \n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
    }
}
