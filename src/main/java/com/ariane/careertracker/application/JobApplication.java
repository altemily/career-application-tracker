package com.ariane.careertracker.application;

import java.time.LocalDate;

public class JobApplication {

    private String companyName;
    private String position;
    private ApplicationStatus status;
    private LocalDate applicationDate;

    public JobApplication(String companyName, String position) {
        this.companyName = companyName;
        this.position = position;
        this.status = ApplicationStatus.APPLIED;
        this.applicationDate = LocalDate.now();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void updateStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Company: " + companyName +
                " | Position: " + position +
                " | Status: " + status +
                " | Applied on: " + applicationDate;
    }
}
