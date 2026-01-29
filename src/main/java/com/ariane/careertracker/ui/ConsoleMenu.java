package com.ariane.careertracker.ui;

import com.ariane.careertracker.service.JobApplicationService;

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
                case 3 -> exit();
                default -> System.out.println("Invalid option.");
            }

        } while (option != 3);
    }

    private void showMenu() {
        System.out.println("\n=== Job Application Tracker ===");
        System.out.println("1 - Add job application");
        System.out.println("2 - List applications");
        System.out.println("3 - Exit");
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

        service.addApplication(company, position);
        System.out.println("Application added successfully!");
    }

    private void listApplications() {
        if (service.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        service.getAll().forEach(System.out::println);
    }

    private void exit() {
        System.out.println("Good luck in your job search!");
    }
}
