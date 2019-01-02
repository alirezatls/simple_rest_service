package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.AddressDao;
import com.hibernate.master.demo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressDao addressDao;

    @GetMapping(path = "/rs/ad/{id}")
    public Address findAdd(@PathVariable Integer id) {
        return addressDao.getAddressById(id);
    }
    @GetMapping(path = "/rs/ad/adds")
    public List<Address> findAllAdd() {
        return addressDao.getAllAddress();
    }
}
