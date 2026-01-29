# Career Application Tracker 🚀

Um rastreador de candidaturas em desenvolvimento (WIP) projetado para ajudar profissionais a organizarem suas aplicações a vagas de emprego. Permite registrar empresas, cargos e acompanhar o status de cada processo seletivo através de uma interface de linha de comando (CLI).

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Gerenciador de Dependências:** Gradle 9.0.0
- **Armazenamento de Dados:** CSV (`applications.csv`)

---

## ✨ Funcionalidades Atuais

Atualmente, o sistema oferece as seguintes operações via terminal:

- **Adicionar candidatura:** Registra o nome da empresa e o cargo desejado. O status inicial é automaticamente definido como `APPLIED` e a data atual é registrada.
- **Listar candidaturas:** Exibe todas as candidaturas salvas no CSV.
- **Persistência automática:** Todos os dados são armazenados em arquivo CSV para não serem perdidos ao fechar a aplicação.

---

## 🚀 Como Executar o Projeto

Certifique-se de ter o **JDK 21** instalado.

1. Clone o repositório:
   ```bash
   git clone https://github.com/altemily/career-application-tracker.git

2. Navegue até a pasta do projeto:

    ```bash
    cd career-application-tracker


3. Execute via Gradle Wrapper:

    ```bash
    Linux/Mac: ./gradlew run
   Windows: gradlew.bat run

---

## 📂 Estrutura do Projeto

- **`model`**: Contém a classe `JobApplication` e o enum `ApplicationStatus` (`APPLIED`, `INTERVIEW`, `OFFER`, `REJECTED`).
- **`service`**: Gerencia a lógica de negócio e o armazenamento em CSV.
- **`ui`**: Controla a interação com o usuário via `ConsoleMenu`.

---

## 🚧 Próximos Passos (WIP)

- [ ] Implementar edição de status para candidaturas existentes
- [ ] Adicionar filtros de busca (por empresa ou status)
- [ ] Melhorar o tratamento de erros na leitura do CSV
- [ ] Criar testes unitários para o serviço de armazenamento
 armazenamento