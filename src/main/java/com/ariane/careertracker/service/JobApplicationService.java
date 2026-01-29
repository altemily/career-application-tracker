package com.ariane.careertracker.service;

import com.ariane.careertracker.model.JobApplication;

import java.util.List;

public class JobApplicationService {

    private final JobApplicationStorage storage = new JobApplicationStorage();
    private final List<JobApplication> applications;

    public JobApplicationService() {
        this.applications = storage.load();
    }

    public void addApplication(String company, String position) {
        applications.add(new JobApplication(company, position));
        storage.save(applications);
    }

    public List<JobApplication> getAll() {
        return applications;
    }

    public boolean isEmpty() {
        return applications.isEmpty();
    }
}
