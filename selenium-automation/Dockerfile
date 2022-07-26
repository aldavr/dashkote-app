FROM openjdk:8u191-jre-alpine3.8

# Installing extra dependancies
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/selenium

# ADD .jar under target from host into this image
ADD target/selenium-automation.jar 			selenium-automation.jar
ADD target/selenium-automation-tests.jar 	selenium-automation-tests.jar
ADD target/libs							    libs

# In case of any other dependency like .csv / .json / .xls please ADD them as well
ADD smokeTest.xml				            smokeTest.xml


# ADD health check script (it will check if grid hub is up and running)
ADD healthcheck.sh                          healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh

# Building Localy
#   docker build -t test-automation .
#   docker run -it test-automation