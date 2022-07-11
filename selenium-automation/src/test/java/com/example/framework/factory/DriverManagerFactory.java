package com.example.framework.factory;


import com.example.framework.constants.DriverType;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType driverType) {
        switch (driverType) {
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            case DOCKER -> {
                return new DockerManager();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
