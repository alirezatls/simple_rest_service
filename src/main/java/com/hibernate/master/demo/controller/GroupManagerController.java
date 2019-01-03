package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.ManagerDao;
import com.hibernate.master.demo.entity.GroupManager;
import com.hibernate.master.demo.exception.NoSuchManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GroupManagerController {

    @Autowired
    ManagerDao managerDao;

    @GetMapping(path = "/rs/gm/managers/{id}")
    public GroupManager findGrm(@PathVariable int id) {
        GroupManager manager = managerDao.getManagerById(id);
        if(manager == null)
            throw new NoSuchManagerException("No Such Manager->"+id);
        else
            return manager;
    }

    @GetMapping(path = "/rs/gm/managers")
    public List<GroupManager> findAllGrm() {
        return managerDao.getAllManager();
    }

    @PostMapping(path = "/rs/gm/managers")
    public ResponseEntity<Object> postManager(@Valid @RequestBody GroupManager man) {

        GroupManager manager = managerDao.saveManager(man);
        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(manager.getManagerId());

        return ResponseEntity.created(uri.toUri()).build();
    }

    @DeleteMapping(path = "/rs/gm/managers/{id}")
    public ResponseEntity<Object> deleteManager(@PathVariable int id) {
        Integer state = managerDao.removeManagerById(id);
        if(state<=0)
            throw new NoSuchManagerException("No Such Manager->"+id);
        else
            return ResponseEntity.ok().build();
    }
}
