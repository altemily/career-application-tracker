# Career Application Tracker 🚀

Um rastreador de candidaturas projetado para ajudar profissionais a organizarem suas aplicações em vagas de emprego. Permite registrar empresas, cargos e acompanhar o status de cada processo seletivo através de uma interface de linha de comando (CLI).

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Gerenciador de Dependências:** Gradle 9.0.0
- **Armazenamento de Dados:** CSV (`applications.csv`)

---

## ✨ Funcionalidades (MPV)

- Adicionar candidatura
- Listar todas as candidaturas
- Atualizar status da candidatura
- Filtrar candidaturas por status
- Persistência em arquivo .csv
- Interface via console (menu interativo)

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

## 🧱 Arquitetura

O projeto segue uma separação simples de responsabilidades:
- `model`: entidades e enums
- `service`: regras de negócio e persistência
- `ui`: interação com o usuário via console
---

