package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;

public interface AddAddressByUserUseCase {
    Address add(Address address) throws AddAddressByUserFailedException ;

    class AddAddressByUserFailedException extends Exception {
        public AddAddressByUserFailedException(String message) {
            super(message);
        }
    }
}
