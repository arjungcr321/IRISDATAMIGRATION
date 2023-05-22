package com.integration.iris.entity;

import java.time.LocalDateTime;

import com.integration.iris.enumerations.InsuranceCategory;
import com.integration.iris.enumerations.PandICover;
import com.integration.iris.enumerations.PolicyCover;

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
@Entity
public class InsurancePolicyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insurancePolicyNo;

    private String insurancePolicyName;
    private Long deductible;
    private String owner;
    private LocalDateTime policyStartDate;
    private LocalDateTime policyEndDate;
    private PolicyCover policyCover;
    private PandICover club;
    private InsuranceCategory insuranceCategory;
    private String insurer;
    private String geographicScope;
}
