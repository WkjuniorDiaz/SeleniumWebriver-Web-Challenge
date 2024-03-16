package utils;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebdriverManager());
    }
}
