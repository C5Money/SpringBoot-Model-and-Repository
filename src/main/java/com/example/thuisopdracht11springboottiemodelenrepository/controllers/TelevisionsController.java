package com.example.thuisopdracht11springboottiemodelenrepository.controllers;

import com.example.thuisopdracht11springboottiemodelenrepository.exceptions.RecordNotFoundException;
import com.example.thuisopdracht11springboottiemodelenrepository.models.Television;
import com.example.thuisopdracht11springboottiemodelenrepository.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tvs")
public class TelevisionsController {
//    Instance Variables
    @Autowired
    private TelevisionRepository tvRepo;

//    ----------------------------------------------------------------------
//    Gets:
//    ----------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Television>> retrieveTvs(){
        return ResponseEntity.ok().body(tvRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> retrieveTv(@PathVariable Long id){
        Optional<Television> optionalTv = tvRepo.findById(id);
        if(optionalTv.isEmpty() || id <= 0){
            throw new RecordNotFoundException("This id: " + id + " is empty or doesn't work");
        }
        Television television = optionalTv.get();
        return ResponseEntity.ok().body(television);
    }

    @GetMapping("/search")
    public ResponseEntity<Television> retrieveTv(@RequestParam String name){
        Optional<Television> optionalTv = tvRepo.findByNameContainingIgnoreCase(name);
        if( (optionalTv.isEmpty()) ){
            throw new RecordNotFoundException("No result found.");
        }
        Television television = optionalTv.get();
        return ResponseEntity.ok().body(television);
    }

//    ----------------------------------------------------------------------
//    Posts:
//    ----------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Television> createTv(@RequestBody Television tv){
        tvRepo.save(tv);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + tv.getId()).toUriString());
        return ResponseEntity.created(uri).body(tv);
    }

//    ----------------------------------------------------------------------
//    Puts:
//    ----------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTv(@RequestBody Television tv, @PathVariable Long id){
        Optional<Television> optionalTv = tvRepo.findById(id);
        if( id <= 0 || optionalTv.isEmpty()){
            throw new RecordNotFoundException("This id: \" + id + \" cannot be found or is empty");
        }
        Television television = tvRepo.save(tv);
        return ResponseEntity.accepted().body(television);
    }

    //    ----------------------------------------------------------------------
//    Deletes:
//    ----------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTv(@PathVariable Long id){
        Optional<Television> optionalTv = tvRepo.findById(id);
        if( (id <= 0) || optionalTv.isEmpty() ){
            throw new RecordNotFoundException("This id: " + id + " cannot be found or is empty.");
        }
        tvRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
