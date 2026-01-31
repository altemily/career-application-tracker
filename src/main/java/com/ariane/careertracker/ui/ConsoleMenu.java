package com.ariane.careertracker.ui;

import com.ariane.careertracker.model.ApplicationStatus;
import com.ariane.careertracker.model.JobApplication;
import com.ariane.careertracker.service.JobApplicationService;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final JobApplicationService service = new JobApplicationService();

    public void start() {
        int option;

        do {
            showMenu();
            option = readOption();

            switch (option) {
                case 1 -> addApplication();
                case 2 -> listApplications();
                case 3 -> updateStatus();
                case 4 -> exit();
                default -> System.out.println("Invalid option.");
            }

        } while (option != 4);
    }

    private void showMenu() {
        System.out.println("\n=== Job Application Tracker ===");
        System.out.println("1 - Add job application");
        System.out.println("2 - List applications");
        System.out.println("3 - Update application status");
        System.out.println("4 - Exit");
        System.out.print("Choose an option: ");
    }

    private int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addApplication() {
        System.out.print("Company name: ");
        String company = scanner.nextLine();

        System.out.print("Position: ");
        String position = scanner.nextLine();

        JobApplication application = new JobApplication(company, position);
        service.add(application);

        System.out.println("Application added successfully!");
    }

    private void listApplications() {
        List<JobApplication> applications = service.list();

        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + " - " + applications.get(i));
        }
    }

    private void updateStatus() {
        List<JobApplication> applications = service.list();

        if (applications.isEmpty()) {
            System.out.println("No applications to update.");
            return;
        }

        listApplications();

        System.out.print("Choose application number: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("New status:");
        for (ApplicationStatus status : ApplicationStatus.values()) {
            System.out.println("- " + status);
        }

        System.out.print("Type status: ");
        ApplicationStatus newStatus =
                ApplicationStatus.valueOf(scanner.nextLine().toUpperCase());

        boolean updated = service.updateStatus(index, newStatus);

        if (updated) {
            System.out.println("Status updated successfully!");
        } else {
            System.out.println("Invalid application number.");
        }
    }

    private void exit() {
        System.out.println("Good luck in your job search!");
    }
}
