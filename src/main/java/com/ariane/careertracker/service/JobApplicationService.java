package com.ariane.careertracker.service;

import com.ariane.careertracker.model.ApplicationStatus;
import com.ariane.careertracker.model.JobApplication;

import java.util.List;

public class JobApplicationService {

    private final JobApplicationStorage storage;
    private final List<JobApplication> applications;

    public JobApplicationService() {
        this.storage = new JobApplicationStorage();
        this.applications = storage.load();
    }
    // Adicionar
    public void add(JobApplication application) {
        applications.add(application);
        storage.save(applications);
    }
    // Listar
    public List<JobApplication> list() {
        return applications;
    }
    // Editar
    public boolean updateStatus(int index, ApplicationStatus newStatus) {
        if (index < 0 || index >= applications.size()) {
            return false;
        }

        applications.get(index).updateStatus(newStatus);
        storage.save(applications);
        return true;
    }

    // Filtro por status
    public List<JobApplication> filterByStatus(ApplicationStatus status) {
        return applications.stream()
                .filter(app -> app.getStatus() == status)
                .toList();
    }
}
