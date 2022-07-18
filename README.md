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

        $ mvn test -Denv=PRODUCTION -Dbrowser=chrome
        $ mvn test -Dtest=ParallelTests -Dbrowser=docker
