package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.AddressDao;
import com.hibernate.master.demo.entity.Address;
import com.hibernate.master.demo.exception.NoSuchAddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressDao addressDao;

    @GetMapping(path = "/rs/ad/addresses/{id}")
    public Address findAdd(@PathVariable Integer id) {
        Address address = addressDao.getAddressById(id);
        if(address == null)
            throw new NoSuchAddressException("No Such Address");
        else
            return address;
    }

    @GetMapping(path = "/rs/ad/addresses")
    public List<Address> findAllAdd() {
        return addressDao.getAllAddress();
    }

    @PostMapping(path = "/rs/ad/addresses")
    public ResponseEntity<Object> postAddress(@Valid @RequestBody Address add) {
        Address address = addressDao.saveAddress(add);
        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("id").
                buildAndExpand(address.getAddressId());

        return ResponseEntity.created(uri.toUri()).build();
    }

    @DeleteMapping(path = "/rs/ad/addresses/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable int id) {
        Integer state = addressDao.removeAddressById(id);
        if(state<=0)
            throw new NoSuchAddressException("No Such Address");
        else
            return ResponseEntity.ok().build();
    }
}
