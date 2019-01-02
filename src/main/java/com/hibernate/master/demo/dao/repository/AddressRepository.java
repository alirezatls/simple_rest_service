package com.hibernate.master.demo.dao.repository;

import com.hibernate.master.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Integer deleteAddressByAddressId(Integer addressId);
}
