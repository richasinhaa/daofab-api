package com.api.daofab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.daofab.model.Child;
import com.api.daofab.model.ChildJsonObject;
import com.api.daofab.model.Parent;
import com.api.daofab.repository.ChildRepository;
import com.api.daofab.repository.ParentRepository;

/** Business layer for child **/

@Service
public class ChildService {
	
	private ChildRepository repository;
	
	private ParentRepository pRepository;

    public ChildService(ChildRepository repository, ParentRepository pRepository) {
        this.repository = repository;
        this.pRepository = pRepository;
    }
    
    /** Fetch all children **/
    
    public List<Child> list() {
		return repository.findAll();
    	
    }
    
    /** Convert JSON object to Child object and save to database **/

    public Iterable<Child> save(List<ChildJsonObject> jsonObjects) {
    	List<Child> children = new ArrayList<Child>();
    	for(ChildJsonObject j : jsonObjects) {
    		Parent parent = pRepository.findById(j.getParentId()).orElseThrow();
    		Child c = new Child();
    		c.setId(j.getId());
    		c.setPaidAmount(j.getPaidAmount());
    		c.setReceiver(parent.getReceiver());
    		c.setSender(parent.getSender());
    		c.setTotalAmount(parent.getTotalAmount());
    		c.setParentId(j.getParentId());
    		
    		children.add(c);
    		
    	}
        return repository.saveAll(children);
    }

}
