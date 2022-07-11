package com.example.framework.tests;

import org.testng.annotations.*;

public class TestNGAnnotation {

    // ***************************************************************************************
    // TestNG Annotation Examples
    // ***************************************************************************************

    // The annotated method will be run only once before all tests in this suite have run.
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("In beforeSuite");
    }

    // The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
    @BeforeTest
    public void beforeTest() {
        System.out.println("In beforeTest");
    }

    // The annotated method will be run only once before the first test method in the current class is invoked.
    @BeforeClass
    public void beforeClass() {
        System.out.println("In beforeClass");
    }

    // The annotated method will be run before each test method.
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("In beforeMethod");
    }

    // The annotated method will be run after each test method.
    @AfterMethod
    public void afterMethod() {
        System.out.println("In afterMethod");
    }

    // The annotated method will be run only once after all the test methods in the current class have run.
    @AfterClass
    public void afterClass() {
        System.out.println("In afterClass");
    }

    // The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
    @AfterTest
    public void afterTest() {
        System.out.println("In afterTest");
    }

    // The annotated method will be run only once after all tests in this suite have run.
    @AfterSuite
    public void afterSuite() {
        System.out.println("In afterSuite");
    }
}
