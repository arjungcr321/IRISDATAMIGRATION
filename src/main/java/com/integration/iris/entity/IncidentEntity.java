package com.integration.iris.entity;

import java.time.LocalDateTime;

import com.integration.iris.enumerations.IncidentCause;
import com.integration.iris.enumerations.IncidentInformation;
import com.integration.iris.enumerations.IncidentLocation;
import com.integration.iris.enumerations.InsuranceCategory;
import com.integration.iris.enumerations.InsuranceStatus;
import com.integration.iris.enumerations.ShipmentType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncidentEntity {
    private String incidentNo;
    private String incidentName;
    private LocalDateTime dateOfIncident;
    private String description;
    private InsuranceCategory insuranceCategory;
    private String owner;
    private String majorIncidentNumber;
    private String insuredVessel;
    private String insuredVoyage;
    private String pAndIPolicy;
    private String routeCode;
    private Long insurancePolicy;
    private String location;
    private String caseId;
    private IncidentCause incidentCause;
    private IncidentLocation incidentLocation;
    private InsuranceStatus status;
    private ShipmentType type;
    private String operator;
    private IncidentInformation information;
    private String gaAdjuster;
    private String gaSurveyor;
    private String gaCollector;
}
