package com.devStack.database.repository;

import com.devStack.database.entity.Catagory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Long> {

}
