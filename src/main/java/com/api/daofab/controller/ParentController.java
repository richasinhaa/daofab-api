package com.api.daofab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.daofab.model.ChildDTO;
import com.api.daofab.model.Parent;
import com.api.daofab.service.ParentService;

@RestController
@RequestMapping("/parents")
public class ParentController {

    private ParentService service;

    public ParentController(ParentService service) {
        this.service = service;
    }
    
    /** Get all parents, sorted by id, paginated **/
    @GetMapping("/list")
    public List<Parent> list(
    		@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "2") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return service.list(pageNo, pageSize, sortBy);
    }
}
