package com.devStack.database.service;


import com.devStack.database.entity.Catagory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatagoryService {

    List<Catagory> getAllCatagories();
    Catagory createCatagory (Catagory catagory);
    Catagory getCatagoryById(Long catagory_id);
    Catagory updateCatagory(Long catagory_id , Catagory catagory);
    void deleteCatagoryById(Long catagory_id);


}
