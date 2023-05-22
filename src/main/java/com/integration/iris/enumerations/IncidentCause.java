package com.integration.iris.enumerations;

public enum IncidentCause {
    AC("Aeroplane Crash"),
    BH("Bad/heavy Weather"),
    CON("Contamination"),
    COUP("Coup"),
    CRANE("Crane / Equipment Collapse"),
    CREW("Crew"),
    CUSTOMS("Customs Inspection"),
    CYB("Cyber"),
    DER("Derailment"),
    DET("Detained by Authorities"),
    EARTH("Earthquake"),
    EXPLO("Explosion/Fire"),
    FIRE("Fire Engine Room"),
    FIRE_CON("Fire From Container"),
    FLOOD("Flooding"),
    FLOOD_CAR("Flooding Cargo Hold"),
    HIJ("Hijacking/Piracy"),
    INF("Infestation"),
    MACHI("Machinery Failure"),
    MAIN_EN("Main Engine Breakdown"),
    OMIT("Omission"),
    POWER("Power Failure"),
    ;
    IncidentCause(String s) {
    }
}
