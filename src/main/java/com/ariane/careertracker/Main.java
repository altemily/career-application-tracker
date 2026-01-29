package com.ariane.careertracker;

import com.ariane.careertracker.application.JobApplication;
import com.ariane.careertracker.application.ApplicationStatus;

public class Main {

    public static void main(String[] args) {

        JobApplication application =
                new JobApplication("Google", "Software Engineer");

        System.out.println(application);

        application.updateStatus(ApplicationStatus.INTERVIEW);

        System.out.println(application);
    }
}
