package com.api.daofab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.daofab.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
