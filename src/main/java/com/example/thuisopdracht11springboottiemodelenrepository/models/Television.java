package com.example.thuisopdracht11springboottiemodelenrepository.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="televisions")
public class Television {
//    Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    @Column(name="available_size")
    private Double availableSize;
    @Column(name="refresh_rate")
    private Double refreshRate;
    @Column(name="screen_type")
    private String screenType;
    @Column(name="screen_quality")
    private String screenQuality;
    @Column(name="smart_tv")
    private Boolean smartTv;
    private Boolean wifi;
    @Column(name="voice_control")
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    @Column(name="ambi_light")
    private Boolean ambiLight;
    @Column(name="original_stock")
    private Integer originalStock;
    private Integer sold;


//    Constructor
    public Television(){
    }

    public Television(Long id, String type, String brand, String name, Double price, Double availableSize, Double refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }
}
