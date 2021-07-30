package com.api.daofab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.daofab.model.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long>  {

}
