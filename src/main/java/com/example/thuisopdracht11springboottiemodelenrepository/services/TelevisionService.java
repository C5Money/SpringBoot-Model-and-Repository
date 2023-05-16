package com.example.thuisopdracht11springboottiemodelenrepository.services;

import com.example.thuisopdracht11springboottiemodelenrepository.dtos.TelevisionDto;
import com.example.thuisopdracht11springboottiemodelenrepository.models.Television;
import com.example.thuisopdracht11springboottiemodelenrepository.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@Service
public class TelevisionService {
//    Instance Variables
    @Autowired
    private TelevisionRepository tvRepo;


//    Constructor
//    public TelevisionService(TelevisionRepository tvRepo) {
//        this.tvRepo = tvRepo;
//    }


//    CRUD:
//    CREATE
    public Long createTv(@RequestBody TelevisionDto tvDto){
        Television television = new Television();

        television.setType(tvDto.type);
        television.setBrand(tvDto.brand);
        television.setName(tvDto.name);
        television.setPrice(tvDto.price);
        television.setAvailableSize(tvDto.availableSize);
        television.setRefreshRate(tvDto.refreshRate);
        television.setScreenQuality(tvDto.screenQuality);
        television.setSmartTv(tvDto.smartTv);
        television.setWifi(tvDto.wifi);
        television.setVoiceControl(tvDto.voiceControl);
        television.setBluetooth(tvDto.bluetooth);
        television.setAmbiLight(tvDto.ambiLight);

        tvRepo.save(television);
        return television.getId();
    }


//    READ ONE


//    READ ALL
//    public List<TelevisionDto> readTvs(){
//        List<TelevisionDto> tvs =  tvRepo.findAll();
//
//
//    }

//    UPDATE

//    DELETE




}
