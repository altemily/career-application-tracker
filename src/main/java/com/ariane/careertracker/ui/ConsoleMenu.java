package com.ariane.careertracker.ui;

import com.ariane.careertracker.model.ApplicationStatus;
import com.ariane.careertracker.model.JobApplication;
import com.ariane.careertracker.service.JobApplicationService;

import java.util.List;
import java.util.Scanner;

/**
 * Camada de UI (Interface com o usuário).
 * Responsável apenas por:
 * - Mostrar menus
 * - Ler entradas do usuário
 * - Chamar o service
 *
 * NÃO contém regra de negócio.
 */
public class ConsoleMenu {

    // Scanner único para ler entradas do terminal
    private final Scanner scanner = new Scanner(System.in);

    // Service que encapsula toda a lógica do sistema
    private final JobApplicationService service = new JobApplicationService();

    /**
     * Método principal do menu.
     * Controla o loop da aplicação.
     */
    public void start() {
        int option;

        do {
            showMenu();
            option = readOption();

            switch (option) {
                case 1 -> addApplication();
                case 2 -> listApplications();
                case 3 -> updateStatus();
                case 4 -> filterByStatus();
                case 5 -> exit();
                default -> System.out.println("Opção inválida.");
            }

        } while (option != 5);
    }

    /**
     * Exibe o menu principal no console
     */
    private void showMenu() {
        System.out.println("\n=== Job Application Tracker ===");
        System.out.println("1 - Adicionar candidatura");
        System.out.println("2 - Listar candidaturas");
        System.out.println("3 - Atualizar status");
        System.out.println("4 - Filtrar por status");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Lê a opção do usuário de forma segura.
     */
    private int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Fluxo para adicionar uma nova candidatura
     */
    private void addApplication() {
        System.out.print("Nome da empresa: ");
        String company = scanner.nextLine();

        System.out.print("Cargo: ");
        String position = scanner.nextLine();

        JobApplication application = new JobApplication(company, position);
        service.add(application);

        System.out.println("Candidatura adicionada com sucesso!");
    }

    /**
     * Lista todas as candidaturas cadastradas
     */
    private void listApplications() {
        List<JobApplication> applications = service.list();

        if (applications.isEmpty()) {
            System.out.println("Nenhuma candidatura encontrada.");
            return;
        }

        // Exibe índice + dados da candidatura
        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + " - " + applications.get(i));
        }
    }

    /**
     * Atualiza o status de uma candidatura existente
     */
    private void updateStatus() {
        List<JobApplication> applications = service.list();

        if (applications.isEmpty()) {
            System.out.println("Nenhuma candidatura para atualizar.");
            return;
        }

        listApplications();

        System.out.print("Escolha o número da candidatura: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("Novo status:");
        for (ApplicationStatus status : ApplicationStatus.values()) {
            System.out.println("- " + status);
        }

        System.out.print("Digite o status: ");
        ApplicationStatus newStatus =
                ApplicationStatus.valueOf(scanner.nextLine().toUpperCase());

        boolean updated = service.updateStatus(index, newStatus);

        if (updated) {
            System.out.println("Status atualizado com sucesso!");
        } else {
            System.out.println("Número de candidatura inválido.");
        }
    }

    /**
     * Filtra candidaturas com base no status escolhido
     */
    private void filterByStatus() {
        System.out.println("Escolha o status:");

        for (ApplicationStatus status : ApplicationStatus.values()) {
            System.out.println("- " + status);
        }

        System.out.print("Digite o status: ");
        ApplicationStatus chosenStatus =
                ApplicationStatus.valueOf(scanner.nextLine().toUpperCase());

        List<JobApplication> results = service.filterByStatus(chosenStatus);

        if (results.isEmpty()) {
            System.out.println("Nenhuma candidatura com esse status.");
            return;
        }

        results.forEach(System.out::println);
    }

    private void exit() {
        System.out.println("Boa sorte na sua busca por emprego! 🚀");
    }
}
