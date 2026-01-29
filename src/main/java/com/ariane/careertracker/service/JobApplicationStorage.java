package com.ariane.careertracker.service;

import com.ariane.careertracker.model.ApplicationStatus;
import com.ariane.careertracker.model.JobApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationStorage {

    private static final String FILE_NAME = "applications.csv";

    public List<JobApplication> load() {
        List<JobApplication> applications = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return applications;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String company = data[0];
                String position = data[1];
                ApplicationStatus status = ApplicationStatus.valueOf(data[2]);
                LocalDate appliedDate = LocalDate.parse(data[3]);

                applications.add(
                        new JobApplication(company, position, status, appliedDate)
                );
            }
        } catch (IOException e) {
            System.out.println("Error loading applications.");
        }

        return applications;
    }

    public void save(List<JobApplication> applications) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (JobApplication app : applications) {
                writer.write(
                        app.getCompany() + "," +
                                app.getPosition() + "," +
                                app.getStatus() + "," +
                                app.getAppliedDate()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }
}
