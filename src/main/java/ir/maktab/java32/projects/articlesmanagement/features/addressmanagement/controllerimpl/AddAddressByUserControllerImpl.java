package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.controller.AddAddressByUserController;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecaseimpl.AddAddressByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases.AddAddressByUserUseCase;

public class AddAddressByUserControllerImpl implements AddAddressByUserController {
    @Override
    public Address add(Address address) {
        AddAddressByUserUseCase addAddressByUserUseCase = new AddAddressByUserUseCaseImpl();
        Address addAddress = null;
        try {
            addAddress = addAddressByUserUseCase.add(address);
        } catch (AddAddressByUserUseCase.AddAddressByUserFailedException e) {
            e.printStackTrace();
        }
        return addAddress;
    }
}
