package com.integration.iris.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VesselPolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long irisVesselPolicyNo;
    private String vesselPolicyName;


    private Long insurancePolicyNo;
    private Long irisVesselNo;
    private LocalDateTime vesselPolicyEndDate;
    private LocalDateTime vesselPolicyStartDate;

}
