package com.integration.iris.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VesselRawData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long irisVesselNo;

    private String vesselCode;
    private String vesselGroupName;
    private String vesselImoNumber;
    private String vesselName;
    //to make enum
    private String vesselOperator;
    //to make enum
    private String vesselOwnershipType;
}
