package com.ariane.careertracker.model;

import java.time.LocalDate;

public class JobApplication {

    private String company;
    private String position;
    private ApplicationStatus status;
    private LocalDate appliedDate;

    public JobApplication(String company, String position) {
        this.company = company;
        this.position = position;
        this.status = ApplicationStatus.APPLIED;
        this.appliedDate = LocalDate.now();
    }

    public JobApplication(String company, String position,
                          ApplicationStatus status, LocalDate appliedDate) {
        this.company = company;
        this.position = position;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public void updateStatus(ApplicationStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Company: " + company +
                " | Position: " + position +
                " | Status: " + status +
                " | Applied on: " + appliedDate;
    }
}
