package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.repositories.AddressRepository;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases.AddAddressByUserUseCase;

public class AddAddressByUserUseCaseImpl implements AddAddressByUserUseCase {
    private AddressRepository addressRepository = AddressRepository.getInstance();

    @Override
    public Address add(Address address) throws AddAddressByUserFailedException {
        Address saveAddress;
        try {
            validate(address);
            saveAddress = insertAddress(address);
        } catch (AddAddressByUserFailedException e) {
            throw new AddAddressByUserFailedException(e.getMessage());
        }

        return saveAddress;
    }

    private Address insertAddress(Address address) {
        return addressRepository.save(address);
    }

    private void validate(Address address) throws AddAddressByUserFailedException {
        if (address.getCountry() == null || address.getCountry().isEmpty())
            throw new AddAddressByUserFailedException("Country is empty");

        if (address.getCountry().length() > 15)
            throw new AddAddressByUserFailedException("Country is bigger than 15 characters");

        if (address.getCity() == null || address.getCity().isEmpty())
            throw new AddAddressByUserFailedException("City is empty");

        if (address.getCity().length() > 15)
            throw new AddAddressByUserFailedException("City is bigger than 15 characters");

        if (address.getStreet() == null || address.getStreet().isEmpty())
            throw new AddAddressByUserFailedException("Street is empty");

        if (address.getStreet().length() > 15)
            throw new AddAddressByUserFailedException("Street is bigger than 15 characters");

        if (address.getPostalCode() == null || address.getPostalCode().isEmpty())
            throw new AddAddressByUserFailedException("PostalCode is empty");

        if (address.getPostalCode().length() > 10)
            throw new AddAddressByUserFailedException("PostalCode is bigger than 15 characters");

    }


}
