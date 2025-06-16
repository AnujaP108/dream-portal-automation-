# dream-portal-automation-
Automated UI Functional Testing for Dream Portal

This repository contains UI automation scripts for the [Dream Portal](https://arjitnigam.github.io/myDreams/) using **Selenium WebDriver** in **Java**, with integrated logging, reporting, and screenshot capture.

---

## 🔧 Tech Stack
- **Language**: Java
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Browser Driver**: ChromeDriver
- **Logging**: Log4j2
- **Reporting**: Allure Reports / Extent Reports
- **Screenshot Utility**: Captures screenshots on every test step
- **Framework Type**: Modular TestNG-based framework (non-POM version)

---

## 📂 Project Structure
- Selenium WebDriver
- TestNG (Assertions & Execution)
- Maven (Project Build)
- Log4j2 (Logging)
- Screenshot Utility (Each step)
- Allure Report (Reporting)

---

## 🧪 Test Coverage

| Page                | Tests                                                                 |
|---------------------|------------------------------------------------------------------------|
| `index.html`        | Loading animation, main content, and dream button validations         |
| `dreams-diary.html` | Validates 10 entries, good/bad types, and column completeness          |
| `dreams-total.html` | Summary count validation, recurring dream logic                       |

---

## 📁 Folder Structure
dream-portal-automation/
├── src/
│   ├── main/java/pages/               # Page Object Model files
│   └── main/java/utils/               # Logger, Screenshot, Driver setup
│   └── test/java/tests/               # Test classes (TestNG)
├── test-output/                       # Test reports (HTML/Allure)
├── logs/                              # Log4j logs
├── screenshots/                       # Screenshots (every step)
├── pom.xml                            # Maven config with all dependencies
├── log4j2.xml                         # Log config
├── allure-results/ (optional)
├── README.md                          # Fully documented
└── .gitignore

---

▶️ How to Run
mvn clean test

Generate Allure Report:
allure serve allure-results/

📸 Screenshots
All screenshots are saved automatically after each step in the screenshots/ directory.

📒 Logging
Log files are generated via Log4j and stored in logs/ directory.

 Contribution
This is part of an internship assessment task. Collaboration access has been granted to:

Reviewer: qawingify (GitHub)

🧑‍💻 Author
Name: Anuja Patil
LinkedIn: (https://www.linkedin.com/in/anuja-patil-58a6302b5/)
Email: anujarajpatil@gmail.com

