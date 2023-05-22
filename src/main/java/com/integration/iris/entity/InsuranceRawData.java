package com.integration.iris.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class InsuranceRawData {
    private Long insuranceId;
    private String vesselName;
   private String insuranceType;
    private Date insurancePolicyStartDate;
    private Date insurancePolicyEndDate;
    private String insurancePolicyName;

    public InsuranceRawData(Long insuranceId,String vesselName, String insuranceType, Date insurancePolicyStartDate, Date insurancePolicyEndDate, String insurancePolicyName) {
        this.insuranceId = insuranceId;
        this.vesselName = vesselName;
        this.insuranceType = insuranceType;
        this.insurancePolicyStartDate = insurancePolicyStartDate;
        this.insurancePolicyEndDate = insurancePolicyEndDate;
        this.insurancePolicyName = insurancePolicyName;
    }
}
