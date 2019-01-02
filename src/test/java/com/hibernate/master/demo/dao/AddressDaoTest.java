package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {

    @Autowired
    AddressDao addressDao;

    @Test
    @Transactional
    public void getAddressById() {
        Address address = addressDao.getAddressById(100);
        System.out.println(address.toString());
        //First Level Cache
        Address address1 = addressDao.getAddressById(100);
        System.out.println(address1);
    }

    @Test
    @DirtiesContext
    public void saveOrUpdateAddress() {
    }

    @Test
    @DirtiesContext
    public void removeAddressById() {
    }

    @Test
    public void getAllAddress() {
        List<Address> allAddress = addressDao.getAllAddress();
    }

    @Test
    public void gett() {
        List<Address> addressList2 = addressDao.getAllAddress();
    }
}