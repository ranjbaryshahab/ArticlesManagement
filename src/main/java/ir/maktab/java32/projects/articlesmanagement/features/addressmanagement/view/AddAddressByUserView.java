package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.view;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.controller.AddAddressByUserController;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.controllerimpl.AddAddressByUserControllerImpl;

import java.util.Scanner;

public class AddAddressByUserView {
    private Scanner scanner = new Scanner(System.in);

    public Address add() {
        Address address = new Address();
        System.out.println("Please enter country : ");
        address.setCountry(scanner.nextLine());

        System.out.println("Please enter city : ");
        address.setCity(scanner.nextLine());

        System.out.println("Please enter street : ");
        address.setStreet(scanner.nextLine());

        System.out.println("Please enter postalCode : ");
        address.setPostalCode(scanner.nextLine());

        AddAddressByUserController addAddressByUserController = new AddAddressByUserControllerImpl();
        return addAddressByUserController.add(address);
    }
}
