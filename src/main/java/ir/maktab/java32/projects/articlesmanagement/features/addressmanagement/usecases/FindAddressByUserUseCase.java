package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;

public interface FindAddressByUserUseCase {
    Address findById(int id) throws FindAddressByUserFailedException;

    class FindAddressByUserFailedException extends Exception {
        public FindAddressByUserFailedException(String message) {
            super(message);
        }
    }
}
