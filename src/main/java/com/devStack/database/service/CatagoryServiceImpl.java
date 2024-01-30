package com.devStack.database.service;

import com.devStack.database.entity.Catagory;
import com.devStack.database.repository.CatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepository catagoryRepository;
    @Override
    public List<Catagory> getAllCatagories() {
        return catagoryRepository.findAll();
    }

    @Override
    public Catagory createCatagory(Catagory catagory) {
        return catagoryRepository.save(catagory);
    }

    @Override
    public Catagory getCatagoryById(Long id) {
        return catagoryRepository.findById(id).orElse(null);
    }

    @Override
    public Catagory updateCatagory(Long id, Catagory catagory) {
        Catagory existingCatagory = catagoryRepository.findById(id).orElse(null);
        if (existingCatagory != null){

            existingCatagory.setName(catagory.getName());
            return catagoryRepository.save(existingCatagory);
        }else {
            return null;
        }
    }

    @Override
    public void deleteCatagoryById(Long catagory_id) {
        catagoryRepository.deleteById(catagory_id);
    }
}
