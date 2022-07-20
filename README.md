# Prerequisites

- Git

        choco install git -y
- Java (Amazon Corretto 17 OpenJDK)

        choco install corretto17jdk
- Maven

        choco install maven
- IntelliJ IDEA

        choco install intellijidea-community
- Visual Studio Code

        choco install vscode -y
        choco install vscode-java -y
        choco install vscode-java-test -y


# Test Execution

        $ mvn test -Denv=PRODUCTION -Dbrowser=Chrome
        // GitHub Workflow
        $ mvn test -Dtest=ParallelTests -Dbrowser=remoteChrome
        // Docker
        $ mvn test -Dtest=ParallelTests -Dbrowser=Docker
        // Grid (docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome)
        $ mvn test -Dtest=ParallelTests -Dbrowser=Grid

# Build Java Package

        $ mvn clean package -DskipTests
        // Run (execute inside target directory)
        $ java -cp selenium-automation-1.0-tests.jar:selenium-automation-1.0.jar:libs/* org.testng.TestNG ../smokeTest.xml
