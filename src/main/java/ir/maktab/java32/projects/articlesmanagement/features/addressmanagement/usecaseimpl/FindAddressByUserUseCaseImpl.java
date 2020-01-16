package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.repositories.AddressRepository;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases.FindAddressByUserUseCase;

public class FindAddressByUserUseCaseImpl implements FindAddressByUserUseCase {
    private AddressRepository addressRepository = AddressRepository.getInstance();

    @Override
    public Address findById(int id) throws FindAddressByUserFailedException {
        Address address;
        try {
            validate(id);
            address = findAddressById(id);
        } catch (FindAddressByUserFailedException e) {
            throw new FindAddressByUserFailedException(e.getMessage());
        }
        return address;
    }

    private Address findAddressById(int id) {
        return addressRepository.findById(id);
    }

    private void validate(int id) throws FindAddressByUserFailedException{
        if (id <= 0)
            throw new FindAddressByUserFailedException("This id isn't true!");

        if (findAddressById(id) == null)
            throw new FindAddressByUserFailedException("This id isn't exists!");
    }
}
