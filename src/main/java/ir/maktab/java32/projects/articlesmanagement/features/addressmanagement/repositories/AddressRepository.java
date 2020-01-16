package ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.Address;

public class AddressRepository extends CrudRepository<Address, Integer> {
    private static AddressRepository addressRepository;

    private AddressRepository() {
        setSession(HibernateUtil.getFirstSession());
    }

    public static AddressRepository getInstance() {
        if (addressRepository == null) {
            addressRepository = new AddressRepository();
        }
        return addressRepository;
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
