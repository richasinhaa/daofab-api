package com.api.daofab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.daofab.model.Child;
import com.api.daofab.service.ChildService;

@RestController
@RequestMapping("/children")
public class ChildController {

    private ChildService service;

    public ChildController(ChildService service) {
        this.service = service;
    }

    /** Get all children **/
    @GetMapping("/list")
    public List<Child> list() {
        return service.list();
    }
}
