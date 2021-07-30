package com.api.daofab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.daofab.model.Child;
import com.api.daofab.model.ChildDTO;
import com.api.daofab.model.Parent;
import com.api.daofab.repository.ParentRepository;

@Service
public class ParentService {

    private ParentRepository repository;

    public ParentService(ParentRepository repository) {
        this.repository = repository;
    }
    
    /** Fetch parents from database, given sorting order and pagination data **/
    public List<Parent> list(Integer pageNo, Integer pageSize, String sortBy) {
    	Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    	
    	Page<Parent> pagedResult = repository.findAll(paging);
        
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Parent>();
        }
    }
    
    /** Save parents to database **/
    public Iterable<Parent> save(List<Parent> parents) {
        return repository.saveAll(parents);
    }

}
