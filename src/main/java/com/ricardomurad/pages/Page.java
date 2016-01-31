package com.ricardomurad.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTitle() {
        return this.webDriver.getTitle();
    }

    public abstract String getPath();

}