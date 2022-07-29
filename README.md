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

        $ mvn -Dtest=ClassName test
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
        $ java -cp selenium-automation-tests.jar:selenium-automation.jar:libs/* org.testng.TestNG ../smokeTest.xml


# Setup Local Docker Database
  
- Pull the SQL server

      $ docker pull mcr.microsoft.com/mssql/server:2019-latest

- Run container image with Docker

      $ docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=<YourStrong@Passw0rd>" \
       -p 1433:1433 --name sql1 --hostname sql1 \
       -d mcr.microsoft.com/mssql/server:2019-latest
- Verify 

      $ docker exec -it sql1 bash
- Connect

      Server Name: localhost,1433
      Login: sa
      Password: <YourStrong@Passw0rd>

https://docs.microsoft.com/en-us/sql/linux/quickstart-install-connect-docker?view=sql-server-linux-ver15&pivots=cs1-bash


