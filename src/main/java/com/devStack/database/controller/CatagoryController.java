package com.devStack.database.controller;

import com.devStack.database.entity.Catagory;
import com.devStack.database.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagories")
@CrossOrigin(origins = "*")
public class CatagoryController {

   @Autowired
    private CatagoryService catagoryService;

   @GetMapping("/get-all")
    public ResponseEntity<List<Catagory>> getAllCatagories (){
      return ResponseEntity.status(200).body(catagoryService.getAllCatagories());
   }

   @GetMapping ("/get-by-id/{id}")
    public ResponseEntity<Catagory> getCatagoryById (@PathVariable Long id){

       Catagory catagory= catagoryService.getCatagoryById(id);

       if (catagory!=null){
           return ResponseEntity.status(200).body(catagoryService.getCatagoryById(id));
       }else {
           return ResponseEntity.status(404).body(null);
       }

   }

   @PostMapping("/create")
    public ResponseEntity<Catagory> createCatagory (@RequestBody Catagory catagory){
       try {
           return ResponseEntity.status(200).body(catagoryService.createCatagory(catagory));
       }catch (Exception e){
           return ResponseEntity.status(500).body(null);
       }
   }

   @PutMapping("/update/{id}")
    public ResponseEntity<Catagory> updateCatagory (@PathVariable Long id, @RequestBody Catagory catagory){

       try {
          return ResponseEntity.status(200).body(catagoryService.updateCatagory(id, catagory));
       }catch (Exception e){
           return ResponseEntity.status(500).body(null);
       }

   }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCatagoryById (@PathVariable Long id){

       Catagory catagory=catagoryService.getCatagoryById(id);
       if (catagory!=null){
           catagoryService.deleteCatagoryById(id);
           return ResponseEntity.status(200).body("deleted Succesfully");

       }else {
          return ResponseEntity.status(500).body("something went wrong,check again");
       }
   }
}
