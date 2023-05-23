package com.example.thuisopdracht11springboottiemodelenrepository.controllers;

import com.example.thuisopdracht11springboottiemodelenrepository.dtos.TelevisionDto;
import com.example.thuisopdracht11springboottiemodelenrepository.exceptions.RecordNotFoundException;
import com.example.thuisopdracht11springboottiemodelenrepository.models.Television;
import com.example.thuisopdracht11springboottiemodelenrepository.repositories.TelevisionRepository;
import com.example.thuisopdracht11springboottiemodelenrepository.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tvs")
public class TelevisionController {
//    Instance Variables
    private final TelevisionService tvService;


//    Constructor
public TelevisionController(TelevisionService tvService){
    this.tvService = tvService;
}


//    ----------------------------------------------------------------------
//    Posts:
//    ----------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<TelevisionDto> createTv(@RequestBody TelevisionDto tvDto) {
        Long newId = tvService.createTv(tvDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newId).toUriString());
        tvDto.id = newId;
        return ResponseEntity.created(uri).body(tvDto);
    }


//    ----------------------------------------------------------------------
//    Gets:
//    ----------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<TelevisionDto>> retrieveTvs(){
        return ResponseEntity.ok().body(tvService.readTvs());
    }
}
