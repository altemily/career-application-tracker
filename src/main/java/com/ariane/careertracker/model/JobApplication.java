package com.ariane.careertracker.model;

import java.time.LocalDate;

public class JobApplication {

    private String company;
    private String position;
    private ApplicationStatus status;
    private LocalDate appliedDate;

    // Construtor simples (quando cria do zero)
    public JobApplication(String company, String position) {
        this.company = company;
        this.position = position;
        this.status = ApplicationStatus.APPLIED;
        this.appliedDate = LocalDate.now();
    }

    // Construtor usado ao carregar do arquivo
    public JobApplication(String company, String position, ApplicationStatus status, LocalDate appliedDate) {
        this.company = company;
        this.position = position;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    // ===== GETTERS =====

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    // ===== SETTERS =====

    public void updateStatus(ApplicationStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return company + " - " + position + " (" + status + ")";
    }
}
