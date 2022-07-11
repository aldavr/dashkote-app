package com.example.framework.factory.abstractFactory;

import com.example.framework.constants.DriverType;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType) {
        switch (driverType) {
            case CHROME -> {
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX -> {
                return new FirefoxDriverManagerAbstract();
            }
            case DOCKER -> {
                return new DockerManagerAbstract();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
