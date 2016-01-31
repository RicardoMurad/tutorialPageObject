package com.ricardomurad.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;


public class GitHubJoinPage extends Page {

    @FindBy(id = "user_login")
    private WebElement userNameInput;

    @FindBy(id = "user_email")
    private  WebElement userEmailInput;


    public GitHubJoinPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getPath() {
        return "/join";
    }

    public void setUsername(String username) {
        userNameInput.sendKeys(username);
    }

    public void setEmail(String email) {
        userEmailInput.sendKeys(email);
    }

    public Boolean isErrorMessageVisible(final String message) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//dd[@class='error' and text()='" + message + "']")));
        return true;
    }

}
