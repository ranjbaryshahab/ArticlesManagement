package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases.FindAddressByUserUseCase;

public class FindAddressByUserControllerImpl implements FindAddressByUserUseCase {
    @Override
    public Address findById(int id) throws FindAddressByUserFailedException {
        FindAddressByUserUseCase findAddressByUserUseCase = new FindAddressByUserControllerImpl();
        Address findAddress = null;
        try {
            findAddress = findAddressByUserUseCase.findById(id);
        } catch (FindAddressByUserFailedException e) {
            e.printStackTrace();
        }
        return findAddress;
    }
}
