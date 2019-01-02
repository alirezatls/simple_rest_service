package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Address;

import java.util.List;

public interface AddressDao {

    Address getAddressById(int id);

    Address saveAddress(Address a);

    Integer removeAddressById(int id);

    List<Address> getAllAddress();
}
