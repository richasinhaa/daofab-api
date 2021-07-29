package com.api.daofab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.daofab.model.Parent;
import com.api.daofab.service.ParentService;

@RestController
@RequestMapping("/parents")
public class ParentController {

    private ParentService service;

    public ParentController(ParentService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public Iterable<Parent> list() {
        return service.list();
    }
}
