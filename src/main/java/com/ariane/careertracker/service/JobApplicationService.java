package com.ariane.careertracker.service;

import com.ariane.careertracker.model.ApplicationStatus;
import com.ariane.careertracker.model.JobApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationService {

    private final List<JobApplication> applications = new ArrayList<>();

    public void addApplication(String company, String position) {
        JobApplication application = new JobApplication(
                company,
                position,
                ApplicationStatus.APPLIED,
                LocalDate.now()
        );
        applications.add(application);
    }

    public List<JobApplication> getAll() {
        return applications;
    }

    public boolean isEmpty() {
        return applications.isEmpty();
    }
}
