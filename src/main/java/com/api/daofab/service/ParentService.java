package com.api.daofab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.daofab.model.Parent;
import com.api.daofab.repository.ParentRepository;

@Service
public class ParentService {

    private ParentRepository repository;

    public ParentService(ParentRepository repository) {
        this.repository = repository;
    }

    public Iterable<Parent> list() {
        return repository.findAll();
    }

    public Iterable<Parent> save(List<Parent> parents) {
        return repository.saveAll(parents);
    }

}
