package com.example.thuisopdracht11springboottiemodelenrepository.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class TelevisionDto {
//    DTO Variables
    public Long id;
    @NotBlank
    public String type;
    @NotBlank
    public String brand;
    public String name;
    @NotBlank
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean bluetooth;
    public Boolean ambiLight;

}
