package com.ricardomurad;

import com.ricardomurad.utils.PropertyLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static com.ricardomurad.utils.PropertyLoader.loadProperty;
import static java.lang.Integer.parseInt;

public abstract class SeleniumBaseTest {

    protected  WebDriver webDriver;
    protected String baseUrl;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", loadProperty("chrome.driver.path"));
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(parseInt(loadProperty("test.timeout")), TimeUnit.SECONDS);
        baseUrl = loadProperty("base.url");
        this.initPage();
    }

    @After
    public void tearDown() {
        if(this.webDriver != null) {
           webDriver.manage().deleteAllCookies();
            webDriver.close();

        }
    }

    protected abstract void initPage();
}